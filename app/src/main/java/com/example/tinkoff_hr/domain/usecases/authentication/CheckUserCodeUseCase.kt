package com.example.tinkoff_hr.domain.usecases.authentication

import com.example.tinkoff_hr.domain.entities.Token
import com.example.tinkoff_hr.domain.repositories_interface.AuthenticationRepository
import io.reactivex.Single
import javax.inject.Inject

class CheckUserCodeUseCase @Inject constructor(private val authenticationRepository: AuthenticationRepository) {
    operator fun invoke(email: String, code: Int): Single<Token> {
        return authenticationRepository.checkUserCode(email, code)
    }
}