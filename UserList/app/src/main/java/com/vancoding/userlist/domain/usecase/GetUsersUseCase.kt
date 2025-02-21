package com.vancoding.userlist.domain.usecase

import com.vancoding.userlist.domain.model.UserResponse
import com.vancoding.userlist.domain.repository.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository,
) {
    suspend operator fun invoke(page: Int): Result<UserResponse> {
        return repository.getContactList(page)
    }
}