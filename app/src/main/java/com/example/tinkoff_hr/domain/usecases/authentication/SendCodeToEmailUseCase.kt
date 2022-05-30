package com.example.tinkoff_hr.domain.usecases.authentication

import com.example.tinkoff_hr.domain.repositories_interface.AuthenticationRepository
import io.reactivex.Completable
import javax.inject.Inject

class SendCodeToEmailUseCase @Inject constructor(private val authenticationRepository: AuthenticationRepository) {
    operator fun invoke(email: String): Completable {
        return authenticationRepository.sendCodeToEmail(email)
    }
}