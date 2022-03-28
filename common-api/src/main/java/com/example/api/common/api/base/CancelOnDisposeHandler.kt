package com.example.api.common.api.base

import io.reactivex.disposables.Disposable
import retrofit2.Call

class CancelOnDisposeHandler(private val call: Call<*>) : Disposable {
    @Volatile
    private var disposed: Boolean = false

    override fun dispose() {
        disposed = true
        call.cancel()
    }

    override fun isDisposed(): Boolean = disposed
}