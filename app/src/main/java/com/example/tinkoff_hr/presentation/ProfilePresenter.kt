package com.example.tinkoff_hr.presentation

import com.example.tinkoff_hr.data.repositories.WorkerRepositoryImpl
import com.example.tinkoff_hr.domain.entities.Worker
import com.example.tinkoff_hr.domain.usecases.GetWorkerInfoByEmailUseCase
import com.example.tinkoff_hr.domain.usecases.UpdateWorkerByEmailUseCase

class ProfilePresenter{
    private val workerRepository = WorkerRepositoryImpl()
    private val getWorkerInfoByEmail = GetWorkerInfoByEmailUseCase(workerRepository)
    private val updateWorkerByEmail = UpdateWorkerByEmailUseCase(workerRepository)

    fun onAppearing(email: String){
        getWorkerInfoByEmail(email)
        TODO("Not yet implemented")
    }

    fun onSaveWorkerClicked(worker: Worker){
        updateWorkerByEmail(worker)
        TODO("Not yet implemented")
    }
}