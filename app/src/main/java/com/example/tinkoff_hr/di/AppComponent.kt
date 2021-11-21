package com.example.tinkoff_hr.di

import com.example.tinkoff_hr.actionbar.ProfileSettingsActivity
import com.example.tinkoff_hr.di.module.RepositoryModule
import com.example.tinkoff_hr.di.module.UseCasesModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RepositoryModule::class, UseCasesModule::class])

@Singleton
interface AppComponent {
    //Activities
    fun inject(activity: ProfileSettingsActivity)
}