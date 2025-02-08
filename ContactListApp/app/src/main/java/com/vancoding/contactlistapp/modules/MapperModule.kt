package com.vancoding.contactlistapp.modules

import com.vancoding.contactlistapp.data.mapper.UserMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {
    @Provides
    @Singleton
    fun provideUserMapper(): UserMapper {
        return UserMapper()
    }
}