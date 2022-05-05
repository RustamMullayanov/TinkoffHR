package com.example.tinkoff_hr.presentation

import com.example.tinkoff_hr.base.BasePresenter
import com.example.tinkoff_hr.domain.usecases.GetWorkerInfoByIdUseCase
import com.example.tinkoff_hr.views.WorkerProfileView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class WorkerProfilePresenter @Inject constructor(
    private val getWorkerInfoById: GetWorkerInfoByIdUseCase
) : BasePresenter<WorkerProfileView>() {

    // Хотел сделать через onFirstViewAttach(),
    // но не нашел как передать презентеру в конструктор email
    fun onAppearing(id: String) {
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
}