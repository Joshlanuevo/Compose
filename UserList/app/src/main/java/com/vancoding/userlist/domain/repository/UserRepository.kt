package com.vancoding.userlist.domain.repository

import com.vancoding.userlist.domain.model.UserResponse

interface UserRepository {
    suspend fun getContactList(page: Int): Result<UserResponse>
}