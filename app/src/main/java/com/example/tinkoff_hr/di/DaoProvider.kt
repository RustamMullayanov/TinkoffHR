package com.example.tinkoff_hr.di

import android.content.Context
import androidx.room.Room
import com.example.tinkoff_hr.BuildConfig
import com.example.tinkoff_hr.data.dao.AppDatabase
import com.example.tinkoff_hr.data.dao.RestaurantReviewsDao
import javax.inject.Inject

class DaoProvider @Inject constructor(context: Context) {

    private val database = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        BuildConfig.DB_NAME
    ).build()

    val restaurantReviewsDao: RestaurantReviewsDao
        get() = database.restaurantReviewsDao()
}