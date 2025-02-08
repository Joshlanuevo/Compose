package com.vancoding.contactlistapp.modules

import com.vancoding.contactlistapp.domain.repository.UserRepository
import com.vancoding.contactlistapp.domain.usecases.GetUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetUserUseCase(userRepository: UserRepository): GetUserUseCase {
        return GetUserUseCase(userRepository)
    }
}