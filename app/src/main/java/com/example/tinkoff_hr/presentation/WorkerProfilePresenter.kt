package com.example.tinkoff_hr.presentation

import com.example.tinkoff_hr.domain.usecases.GetWorkerInfoByEmailUseCase
import com.example.tinkoff_hr.views.WorkerProfileView
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class WorkerProfilePresenter @Inject constructor(
    private val getWorkerInfoByEmail: GetWorkerInfoByEmailUseCase
) : MvpPresenter<WorkerProfileView>(){

    // Хотел сделать через onFirstViewAttach(),
    // но не нашел как передать презентеру в конструктор email
    fun onAppearing(email: String){
        val worker = getWorkerInfoByEmail(email)
        viewState.showWorkerInfo(worker)
        viewState.showSuccess("Данные успешно загрузились")
        //TODO("Not yet implemented")
    }
}