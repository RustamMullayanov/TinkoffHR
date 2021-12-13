package com.example.tinkoff_hr.di

import com.example.tinkoff_hr.actionbar.ProfileSettingsActivity
import com.example.tinkoff_hr.di.module.RepositoryModule
import com.example.tinkoff_hr.ui.where_eat.WhereEatFragment
import com.example.tinkoff_hr.ui.workers.WorkersFragment
import com.example.tinkoff_hr.ui.workers.worker_profile.WorkerProfileActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RepositoryModule::class])

@Singleton
interface AppComponent {
    //Activities
    fun inject(activity: ProfileSettingsActivity)
    fun inject(fragment: WorkersFragment)
    fun inject(activity: WorkerProfileActivity)
    fun inject(fragment: WhereEatFragment)
}