package com.example.tinkoff_hr.domain.usecases.authentication

import com.example.tinkoff_hr.domain.entities.worker.UpdatedWorkerInfo
import com.example.tinkoff_hr.domain.repositories_interface.AuthenticationRepository
import io.reactivex.Completable
import javax.inject.Inject

class UserRegisteringUseCase @Inject constructor(private val authenticationRepository: AuthenticationRepository) {
    operator fun invoke(token: String, worker: UpdatedWorkerInfo): Completable {
        return authenticationRepository.userRegistering(token, worker)
    }
}