package com.example.hilt_mvi.retrofit

import retrofit2.http.*

interface ProductRetrofit {
    @GET("products")
    suspend fun getProducts():ProductNetworkEntity


}