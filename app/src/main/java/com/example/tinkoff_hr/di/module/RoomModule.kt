package com.example.tinkoff_hr.di.module

import com.example.tinkoff_hr.data.dao.RestaurantReviewsDao
import com.example.tinkoff_hr.data.dao.RestaurantsDao
import com.example.tinkoff_hr.di.DaoProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideRestaurantReviewsDao(daoProvider: DaoProvider): RestaurantReviewsDao{
        return daoProvider.restaurantReviewsDao
    }

    @Provides
    @Singleton
    fun provideRestaurantsDao(daoProvider: DaoProvider): RestaurantsDao{
        return daoProvider.restaurantsDao
    }
}