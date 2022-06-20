package com.example.hilt_mvi.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "Product_table",)

data class ProductCacheEntity(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val id: Int?=null,
    @SerializedName("image")
    val image: String?=null,
    @SerializedName("name")
    val name: String?=null,
    @SerializedName("price")
    val price: Int? =null,
    @SerializedName("quantity")
    val quantity: Int? =null,
    @SerializedName("restaurant_id")
    val restaurant_id: Int?=null

)
