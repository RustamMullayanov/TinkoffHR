package com.example.api.common.api.base

import com.example.api.common.api.exception.ServerException
import com.example.api.common.api.exception.ServerHttpException
import com.example.api.common.api.exception.ServerSideException
import io.reactivex.*
import io.reactivex.exceptions.Exceptions
import retrofit2.Call

interface EnvelopeCall<T> {

    fun execute(): T

    fun asSingle(): Single<T>

    fun asObservable(): Observable<T>

    fun asMaybe(): Maybe<T>

    fun asCompletable(): Completable
}

class EnvelopeCallImpl<T>(private val call: Call<Envelope<T>>) : EnvelopeCall<T> {

    override fun asSingle(): Single<T> = createObservable().singleOrError()

    override fun asObservable(): Observable<T> = createObservable()

    override fun asMaybe(): Maybe<T> = createObservable().singleElement()

    override fun asCompletable(): Completable = createObservable().ignoreElements()

    private fun createObservable(): Observable<T> = Observable.create(OnSubscribeImpl())

    override fun execute(): T {
        val envelope = executeInternal(call)
        if (envelope.errorMessage != null) {
            throw ServerSideException(envelope.errorMessage)
        }
        return envelope.data!!
    }

    private fun executeInternal(call: Call<Envelope<T>>): Envelope<T> {
        val response = call.execute()
        if (!response.isSuccessful) {
            throw ServerHttpException(
                response.code(),
                response.message(),
                response.errorBody()?.string()
            )
        }

        return response.body() ?: throw ServerSideException(response.errorBody().toString())
    }


    inner class OnSubscribeImpl : ObservableOnSubscribe<T> {
        override fun subscribe(emitter: ObservableEmitter<T>) {
            val callForSubscriber = call.clone()
            // call should be cancelled in case of shutting the observable down
            val disposable = CancelOnDisposeHandler(callForSubscriber)
            emitter.setDisposable(disposable)

            try {
                val envelope = executeInternal(callForSubscriber)
                if (envelope.data != null) {
                    emitter.onNext(envelope.data)
                }
                emitter.onComplete()
            } catch (e: ServerException) {
                Exceptions.throwIfFatal(e)
                if (!disposable.isDisposed) {
                    emitter.onError(e)
                }
            }
        }
    }
}