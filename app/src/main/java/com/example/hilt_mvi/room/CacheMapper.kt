package com.example.hilt_mvi.room

import com.example.hilt_mvi.model.Product
import com.example.hilt_mvi.util.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject constructor():EntityMapper<ProductCacheEntity,Product>
{
    override fun mapFromEntity(entity: ProductCacheEntity):  Product {
        return Product(
            id = entity.id,
            image = entity.image,
            name = entity.name,
            price = entity.price,
            quantity = entity.quantity,
            restaurant_id = entity.restaurant_id

        )
    }
      fun mapToEntity(product: Product): ProductCacheEntity {
        return ProductCacheEntity(
            id = product.id,
            image = product.image,
            name = product.name,
            price = product.price,
            quantity = product.quantity,
            restaurant_id = product.restaurant_id
        )
    }

}