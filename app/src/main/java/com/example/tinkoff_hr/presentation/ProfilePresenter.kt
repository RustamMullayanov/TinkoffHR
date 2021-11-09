package com.example.tinkoff_hr.presentation

import com.example.tinkoff_hr.data.repositories.WorkerRepositoryImpl
import com.example.tinkoff_hr.domain.entities.Worker
import com.example.tinkoff_hr.domain.usecases.GetWorkerInfoByEmail
import com.example.tinkoff_hr.domain.usecases.UpdateWorkerByEmail

class ProfilePresenter{
    private val workerRepository = WorkerRepositoryImpl()
    private val getWorkerInfoByEmail = GetWorkerInfoByEmail(workerRepository)
    private val updateWorkerByEmail = UpdateWorkerByEmail(workerRepository)

    fun onCreate(email: String){
        getWorkerInfoByEmail(email)
        TODO("Not yet implemented")
    }

    fun onSaveWorkerClicked(worker: Worker){
        updateWorkerByEmail(worker)
        TODO("Not yet implemented")
    }
}