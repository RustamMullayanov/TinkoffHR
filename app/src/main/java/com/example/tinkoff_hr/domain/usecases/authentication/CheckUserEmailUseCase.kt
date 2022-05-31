package com.example.tinkoff_hr.domain.usecases.authentication

import com.example.tinkoff_hr.domain.repositories_interface.AuthenticationRepository
import io.reactivex.Completable
import javax.inject.Inject

class CheckUserEmailUseCase @Inject constructor(private val authenticationRepository: AuthenticationRepository) {
    operator fun invoke(email: String): Completable {
        return authenticationRepository.checkUserEmail(email)
    }
}