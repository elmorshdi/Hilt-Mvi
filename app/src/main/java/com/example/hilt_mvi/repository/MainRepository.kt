package com.example.hilt_mvi.repository


 import com.example.hilt_mvi.model.Product
 import com.example.hilt_mvi.retrofit.NetworkMapper
import com.example.hilt_mvi.retrofit.ProductRetrofit
import com.example.hilt_mvi.room.CacheMapper
import com.example.hilt_mvi.room.ProductCacheEntity
import com.example.hilt_mvi.room.ProductDao
import com.example.hilt_mvi.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class MainRepository
constructor(
    private val productDao: ProductDao,
    private val productRetrofit: ProductRetrofit,
    private val networkMapper: NetworkMapper,
    private val cacheMapper :CacheMapper
){
    suspend fun getProducts(): Flow<DataState<List<Product>>> = flow {
        emit(DataState.Loading)
        delay(2000)
        try{
            val networkProduct = productRetrofit.getProducts()
            val products = networkMapper.mapFromEntity(networkProduct)
            for(product in products){
                productDao.insert(cacheMapper.mapToEntity(product))
            }
            val cachedProduct = productDao.get()
            emit(DataState.Success(cachedProduct.map { Product(
                id = it.id,
                image = it.image,
                name = it.name,
                price = it.price,
                quantity = it.quantity,
                restaurant_id = it.restaurant_id) }))
        }catch (e: Exception){
            emit(DataState.Error(e))
        }
    }
}