package com.example.tinkoff_hr.presentation

import com.example.tinkoff_hr.base.BasePresenter
import com.example.tinkoff_hr.data.InMemoryClientCache
import com.example.tinkoff_hr.domain.entities.worker.Worker
import com.example.tinkoff_hr.domain.usecases.GetWorkerInfoByIdUseCase
import com.example.tinkoff_hr.domain.usecases.UpdateWorkerByEmailUseCase
import com.example.tinkoff_hr.views.ProfileView
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class ProfilePresenter @Inject constructor(
    private val getWorkerInfoById: GetWorkerInfoByIdUseCase,
    private val updateWorkerByEmail: UpdateWorkerByEmailUseCase
) : BasePresenter<ProfileView>() {

    override fun onFirstViewAttach() {
        //харкодный worker_id
        onAppearing(1)
    }

    private fun onAppearing(id: Long) {
//        getWorkerInfoById(id)
        Single.just(InMemoryClientCache.client)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ worker ->
                viewState.showWorkerInfo(worker)
            }, { error ->
                viewState.showError("Данные недоступны, повторите попытку позже")
                Timber.e(error)
            }).disposeOnFinish()
    }

    fun onSaveWorkerClicked(worker: Worker) {
//        if (updateWorkerByEmail(worker)){
        if (true) {
            InMemoryClientCache.client = worker
            viewState.showSuccess("Данные успешно сохранены")
            return
        }
        viewState.showError("Произошла ошибка при сохранении данных")
    }
}