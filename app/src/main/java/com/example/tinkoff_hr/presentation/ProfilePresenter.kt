package com.example.tinkoff_hr.presentation

import com.example.tinkoff_hr.data.repositories.WorkerRepositoryImpl
import com.example.tinkoff_hr.domain.entities.Worker
import com.example.tinkoff_hr.domain.usecases.GetWorkerInfoByEmailUseCase
import com.example.tinkoff_hr.domain.usecases.UpdateWorkerByEmailUseCase
import com.example.tinkoff_hr.views.ProfileView
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class ProfilePresenter @Inject constructor(
    private val getWorkerInfoByEmail: GetWorkerInfoByEmailUseCase,
    private val updateWorkerByEmail: UpdateWorkerByEmailUseCase
    ) : MvpPresenter<ProfileView>(){

    override fun onFirstViewAttach() {
        //харкодный email
        onAppearing("test2@tin.koff")
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