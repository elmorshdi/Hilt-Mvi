package com.example.hilt_mvi.retrofit

import com.example.hilt_mvi.model.Product

data class ProductNetworkEntity(
    var data: List<Product>? = null,
    var status: Boolean? = null,
    var count: Int? = null,
    var message: String? = null,
    var token: String? = null

)