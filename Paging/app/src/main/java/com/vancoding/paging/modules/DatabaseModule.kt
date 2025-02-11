package com.vancoding.paging.modules

import android.content.Context
import androidx.room.Room
import com.vancoding.paging.data.local.UnsplashDatabase
import com.vancoding.paging.utils.Constants.UNSPLASH_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): UnsplashDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = UnsplashDatabase::class.java,
            name = UNSPLASH_DATABASE,
        ).build()
    }
}