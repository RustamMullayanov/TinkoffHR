package com.example.tinkoff_hr.presentation

import com.example.tinkoff_hr.base.BasePresenter
import com.example.tinkoff_hr.domain.entities.worker.WorkerItem
import com.example.tinkoff_hr.domain.factories.DataItemFactory
import com.example.tinkoff_hr.domain.usecases.GetWorkersInfoUseCase
import com.example.tinkoff_hr.domain.usecases.SearchWorkersInfoByNameUseCase
import com.example.tinkoff_hr.views.WorkersView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class WorkersPresenter @Inject constructor(
    private val getWorkersInfo: GetWorkersInfoUseCase,
    private val searchWorkersInfoByName: SearchWorkersInfoByNameUseCase
) : BasePresenter<WorkersView>() {

    // workaround until real search doesn't work
    private var workers: List<WorkerItem>? = null

    override fun onFirstViewAttach() {
        getWorkers()
    }

    private fun getWorkers() {
        getWorkersInfo()
            .map { list -> DataItemFactory().createWorkerItems(list) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ workers ->
                this.workers = workers
                viewState.showWorkersInfo(workers)
            }, { error ->
                viewState.showError("Данные недоступны, повторите попытку позже")
                Timber.e(error)
            }).disposeOnFinish()
    }

    fun filterWorkersByName(name: String) {
        if (name.isEmpty() || workers.isNullOrEmpty()) {
            getWorkers()
            return
        }
        // workaround until real search doesn't work
        val filteredWorkers = workers!!.filter { worker ->
            "${worker.surname} ${worker.name}".lowercase().contains(name.lowercase())
        }
        viewState.showWorkersInfo(filteredWorkers)
    }
}