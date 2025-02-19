package com.vancoding.userlist.domain.usecase

import com.vancoding.userlist.domain.model.User
import com.vancoding.userlist.domain.repository.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository,
) {
    suspend operator fun invoke(page: Int): Result<List<User>> {
        return repository.getContactList(page)
    }
}