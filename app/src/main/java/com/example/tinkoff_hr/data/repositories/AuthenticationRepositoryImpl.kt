package com.example.tinkoff_hr.data.repositories

import com.example.tinkoff_hr.data.api.RetrofitServiceAuthentication
import com.example.tinkoff_hr.data.dto.toDomain
import com.example.tinkoff_hr.data.entities.authentication.EmailEntityForApi
import com.example.tinkoff_hr.data.entities.authentication.VerifyUserEntityForApi
import com.example.tinkoff_hr.domain.entities.Token
import com.example.tinkoff_hr.domain.repositories_interface.AuthenticationRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val authentication: RetrofitServiceAuthentication
) : AuthenticationRepository {

    override fun checkUserEmail(email: String): Completable {
        return authentication.checkUserEmail(EmailEntityForApi(email)).asCompletable()
    }

    override fun sendCodeToEmail(email: String): Completable {
        return authentication.sendCodeToEmail(EmailEntityForApi(email)).asCompletable()
    }

    override fun checkUserCode(email: String, code: Int): Single<Token> {
        return authentication.verifyUser(
            "Mobile",
            VerifyUserEntityForApi(email, code)
        ).asSingle().map { it.toDomain() }
    }
}