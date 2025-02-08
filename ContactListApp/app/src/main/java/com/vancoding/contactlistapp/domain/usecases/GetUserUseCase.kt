package com.vancoding.contactlistapp.domain.usecases

import com.vancoding.contactlistapp.domain.model.UserPage
import com.vancoding.contactlistapp.domain.repository.UserRepository
import com.vancoding.contactlistapp.utils.NetworkResultState
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(page: Int): NetworkResultState<UserPage> {
        return userRepository.getContactList(page)
    }
}