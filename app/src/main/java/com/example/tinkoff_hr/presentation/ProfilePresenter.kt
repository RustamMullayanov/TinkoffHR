package com.example.tinkoff_hr.presentation


import com.example.tinkoff_hr.data.repositories.WorkerRepositoryImpl
import com.example.tinkoff_hr.domain.entities.Worker
import com.example.tinkoff_hr.domain.usecases.GetWorkerInfoByEmailUseCase
import com.example.tinkoff_hr.domain.usecases.UpdateWorkerByEmailUseCase
import com.example.tinkoff_hr.views.ProfileView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class ProfilePresenter(private val email: String) : MvpPresenter<ProfileView>(){
    private val workerRepository = WorkerRepositoryImpl()
    private val getWorkerInfoByEmail = GetWorkerInfoByEmailUseCase(workerRepository)
    private val updateWorkerByEmail = UpdateWorkerByEmailUseCase(workerRepository)

    override fun onFirstViewAttach() {
        onAppearing(email)
    }

    private fun onAppearing(email: String){
        val worker = getWorkerInfoByEmail(email)
        viewState.showWorkerInfo(worker)
        viewState.showSuccess("Данные успешно загрузились")
    }

    fun onSaveWorkerClicked(worker: Worker){
        if (updateWorkerByEmail(worker)){
            viewState.showSuccess("Данные успешно сохранены")
            return
        }
        viewState.showError("Произошла ошибка при сохранении данных")
    }
}