package com.example.hilt_mvi.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: ProductCacheEntity):Long

    @Query("SELECT * FROM Product_table")
    suspend fun get():List<ProductCacheEntity>
}