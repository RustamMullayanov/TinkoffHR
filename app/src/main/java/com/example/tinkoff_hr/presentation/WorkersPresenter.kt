package com.example.tinkoff_hr.presentation

import com.example.tinkoff_hr.domain.usecases.GetWorkersInfoUseCase
import com.example.tinkoff_hr.domain.usecases.SearchWorkersInfoByNameUseCase
import com.example.tinkoff_hr.views.WorkersView
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class WorkersPresenter @Inject constructor(
    private val getWorkersInfo: GetWorkersInfoUseCase,
    private val searchWorkersInfoByName: SearchWorkersInfoByNameUseCase
) : MvpPresenter<WorkersView>() {

    override fun onFirstViewAttach() {
        getWorkers()
    }

    private fun getWorkers(){
        val workers = getWorkersInfo()
        viewState.showWorkersInfo(workers)
        viewState.showSuccess("Данные успешно загрузились")
    }

    fun filterWorkersByName(name: String){
        if(name.isEmpty()){
            getWorkers()
            return
        }
        val workers = searchWorkersInfoByName(name)
        viewState.showWorkersInfo(workers)
        viewState.showSuccess("Результат поиска")
    }
}