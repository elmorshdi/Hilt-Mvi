package com.example.hilt_mvi.di

     import com.example.hilt_mvi.repository.MainRepository
import com.example.hilt_mvi.retrofit.NetworkMapper
import com.example.hilt_mvi.retrofit.ProductRetrofit
import com.example.hilt_mvi.room.CacheMapper
import com.example.hilt_mvi.room.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
 import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        blogDao: ProductDao,
        retrofit: ProductRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): MainRepository {
        return MainRepository(blogDao, retrofit, networkMapper, cacheMapper)
    }
}














