package com.example.hilt_mvi.di

import android.content.Context
import androidx.room.Room
  import com.example.hilt_mvi.room.ProductDao
import com.example.hilt_mvi.room.ProductDataBase
import com.example.hilt_mvi.util.Constant.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
 import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideBlogDb(@ApplicationContext context: Context): ProductDataBase {
        return Room
            .databaseBuilder(
                context,
                ProductDataBase::class.java,
                DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideBlogDAO(blogDatabase: ProductDataBase): ProductDao {
        return blogDatabase.productDao()
    }
}