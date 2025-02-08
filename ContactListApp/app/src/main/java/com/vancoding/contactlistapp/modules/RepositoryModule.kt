package com.vancoding.contactlistapp.modules

import com.vancoding.contactlistapp.data.mapper.UserMapper
import com.vancoding.contactlistapp.data.remote.api.ApiService
import com.vancoding.contactlistapp.data.repository.UserRepositoryImpl
import com.vancoding.contactlistapp.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideUserRepository(
        api: ApiService,
        userMapper: UserMapper
    ): UserRepository {
        return UserRepositoryImpl(api, userMapper)
    }
}