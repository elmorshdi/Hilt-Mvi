package com.example.hilt_mvi.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ProductCacheEntity::class], version = 1)
abstract class ProductDataBase : RoomDatabase() {
    abstract fun productDao():ProductDao
}