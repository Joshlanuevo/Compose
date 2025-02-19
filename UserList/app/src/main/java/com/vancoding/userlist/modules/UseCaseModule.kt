package com.vancoding.userlist.modules

import com.vancoding.userlist.domain.repository.UserRepository
import com.vancoding.userlist.domain.usecase.GetUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @Provides
    @ViewModelScoped
    fun provideGetUsersUseCase(
        repository: UserRepository
    ): GetUsersUseCase {
        return GetUsersUseCase(repository)
    }
}