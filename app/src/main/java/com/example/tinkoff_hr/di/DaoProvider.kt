package com.example.tinkoff_hr.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.tinkoff_hr.BuildConfig
import com.example.tinkoff_hr.data.dao.AppDatabase
import com.example.tinkoff_hr.data.dao.RestaurantReviewsDao
import javax.inject.Inject

class DaoProvider @Inject constructor(context: Context) {

    private val database = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        BuildConfig.DB_NAME
    )
        .addCallback(object : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

        }
    }).build()

    val restaurantReviewsDao: RestaurantReviewsDao
        get() = database.restaurantReviewsDao()

    val restaurantsDao
        get() = database.restaurantsDao()

    val cachesStatusDao
        get() = database.cachesStatusDao()
}