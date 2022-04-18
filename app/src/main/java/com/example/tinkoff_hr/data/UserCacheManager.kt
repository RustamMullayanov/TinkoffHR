package com.example.tinkoff_hr.data

import com.example.tinkoff_hr.domain.entities.worker.Worker

object UserCacheManager {
    private lateinit var worker: Worker

    fun setUserCache(worker: Worker) {
        this.worker = worker
    }

    fun getUserId(): String = worker.id

    fun getUserEmail(): String = worker.email

    fun getUserFullName(): String ="${worker.surname} ${worker.name}  ${worker.patronymic ?: ""}"
}