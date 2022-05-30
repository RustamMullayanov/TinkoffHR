package com.example.tinkoff_hr.di

import android.content.Context
import com.example.tinkoff_hr.actionbar.ProfileSettingsActivity
import com.example.tinkoff_hr.di.module.RepositoryModule
import com.example.tinkoff_hr.di.module.RetrofitModule
import com.example.tinkoff_hr.ui.orders.OrdersFragment
import com.example.tinkoff_hr.di.module.RoomModule
import com.example.tinkoff_hr.ui.orders.basket.BasketActivity
import com.example.tinkoff_hr.ui.authentication.CodeActivity
import com.example.tinkoff_hr.ui.authentication.LoginActivity
import com.example.tinkoff_hr.ui.where_eat.WhereEatFragment
import com.example.tinkoff_hr.ui.where_eat.eatery_information.EateryInformationActivity
import com.example.tinkoff_hr.ui.workers.WorkersFragment
import com.example.tinkoff_hr.ui.workers.worker_profile.WorkerProfileActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RepositoryModule::class, RetrofitModule::class, RoomModule::class])
@Singleton
interface AppComponent {
    //Activities
    fun inject(activity: ProfileSettingsActivity)
    fun inject(activity: WorkerProfileActivity)
    fun inject(activity: EateryInformationActivity)
    fun inject(activity: BasketActivity)
    fun inject(activity: LoginActivity)
    fun inject(activity: CodeActivity)

    //Fragments
    fun inject(fragment: WhereEatFragment)
    fun inject(fragment: WorkersFragment)
    fun inject(fragment: OrdersFragment)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}