package com.example.hilt_mvi.retrofit

import com.example.hilt_mvi.model.Product
import com.example.hilt_mvi.util.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor():EntityMapper<ProductNetworkEntity,List<Product>>{
    override fun mapFromEntity(entity: ProductNetworkEntity): List<Product> {
        return entity.data!!
    }




}