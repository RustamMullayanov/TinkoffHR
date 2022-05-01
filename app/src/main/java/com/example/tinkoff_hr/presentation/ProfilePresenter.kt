package com.example.tinkoff_hr.presentation

import com.example.tinkoff_hr.base.BasePresenter
import com.example.tinkoff_hr.domain.entities.worker.UpdatedWorkerInfo
import com.example.tinkoff_hr.domain.usecases.GetWorkerInfoByIdUseCase
import com.example.tinkoff_hr.domain.usecases.UpdateWorkerByIdUseCase
import com.example.tinkoff_hr.views.ProfileView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class ProfilePresenter @Inject constructor(
    private val getWorkerInfoById: GetWorkerInfoByIdUseCase,
    private val updateWorkerById: UpdateWorkerByIdUseCase
) : BasePresenter<ProfileView>() {

    override fun onFirstViewAttach() {
        //харкодный worker_id
        onAppearing("8827aa5d-80ca-4435-9d62-f8b57d4f5f64")
    }

    private fun onAppearing(id: String) {
        getWorkerInfoById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ worker ->
                viewState.showWorkerInfo(worker)
            }, { error ->
                viewState.showError("Данные недоступны, повторите попытку позже")
                Timber.e(error)
            }).disposeOnFinish()
    }

    fun onSaveWorkerClicked(worker: UpdatedWorkerInfo) {
        updateWorkerById(worker)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {viewState.showSuccess("Данные успешно сохранены")},
                { error ->
                    viewState.showError("Не удалось обновить данные, повторите попытку позже")
                    Timber.e(error)
                })
            .disposeOnFinish()
    }
}