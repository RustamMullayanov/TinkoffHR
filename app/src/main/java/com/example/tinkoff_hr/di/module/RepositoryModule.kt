package com.example.tinkoff_hr.di.module

import com.example.tinkoff_hr.data.repositories.WorkerRepositoryImpl
import com.example.tinkoff_hr.domain.repositories_interface.WorkerRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideWorkerRepository(): WorkerRepository {
        return WorkerRepositoryImpl()
    }
}