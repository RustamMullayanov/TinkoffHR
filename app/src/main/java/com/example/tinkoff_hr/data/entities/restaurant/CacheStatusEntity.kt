package com.example.tinkoff_hr.data.entities.restaurant

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = CacheStatusEntity.TABLE_NAME)
class CacheStatusEntity(

    @PrimaryKey @ColumnInfo(name = "table_name")
    val tableName: String,

    @ColumnInfo(name = "caching_date")
    var cachingDate: Long

) {
    companion object {
        const val TABLE_NAME = "caches_status"
    }
}