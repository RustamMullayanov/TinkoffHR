package com.example.tinkoff_hr.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tinkoff_hr.data.entities.restaurant.CacheStatusEntity

@Dao
interface CachesStatusDao {

    @Query("SELECT * FROM ${CacheStatusEntity.TABLE_NAME} where table_name = :tableName")
    fun getCacheStatusByTableName(tableName: String): CacheStatusEntity

    @Insert(entity = CacheStatusEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun saveCacheStatus(cacheStatusEntity: CacheStatusEntity)
}