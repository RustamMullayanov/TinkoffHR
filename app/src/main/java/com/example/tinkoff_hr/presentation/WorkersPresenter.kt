package com.example.tinkoff_hr.presentation

import com.example.tinkoff_hr.domain.usecases.GetWorkersInfoUseCase
import com.example.tinkoff_hr.views.WorkersView
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class WorkersPresenter @Inject constructor(
    private val getWorkersInfo: GetWorkersInfoUseCase
) : MvpPresenter<WorkersView>() {

    override fun onFirstViewAttach() {
        onAppearing()
    }

    private fun onAppearing(){
        val workers = getWorkersInfo()
        viewState.showWorkersInfo(workers)
        viewState.showSuccess("Данные успешно загрузились")
    }
}