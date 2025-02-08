package com.vancoding.contactlistapp.data.mapper

import com.vancoding.contactlistapp.data.model.UserPageResponse
import com.vancoding.contactlistapp.data.model.UserResponse
import com.vancoding.contactlistapp.domain.model.User
import com.vancoding.contactlistapp.domain.model.UserPage
import javax.inject.Inject

class UserMapper @Inject constructor() {
    private fun mapToDomain(userResponse: UserResponse): User {
        return User(
            id = userResponse.id,
            email = userResponse.email,
            first_name = userResponse.first_name,
            last_name = userResponse.last_name,
            avatar = userResponse.avatar,
        )
    }

    fun mapToDomain(userPageResponse: UserPageResponse): UserPage {
        return UserPage(
            users = userPageResponse.data.map { mapToDomain(it) },
            currentPage = userPageResponse.page,
            totalPages = userPageResponse.total_pages,
            totalUsers = userPageResponse.total,
        )
    }
}