package com.example.tinkoff_hr.domain.repositories_interface

import com.example.tinkoff_hr.domain.entities.Token
import io.reactivex.Completable
import io.reactivex.Single

interface AuthenticationRepository {

    fun checkUserEmail(email: String): Completable

    fun sendCodeToEmail(email: String): Completable

    fun checkUserCode(email: String, code: Int): Single<Token>
}