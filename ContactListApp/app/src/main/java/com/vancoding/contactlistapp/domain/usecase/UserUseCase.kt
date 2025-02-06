package com.vancoding.contactlistapp.domain.usecase

import com.vancoding.contactlistapp.domain.repository.UserRepository
import javax.inject.Inject

class UserUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke() = userRepository.getContactList()
}