package com.vancoding.contactlistapp.domain.usecases

import com.vancoding.contactlistapp.domain.model.UserPage
import com.vancoding.contactlistapp.domain.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(page: Int): Result<UserPage> {
        return userRepository.getContactList(page)
    }
}