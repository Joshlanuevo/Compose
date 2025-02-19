package com.vancoding.userlist.domain.repository

import com.vancoding.userlist.domain.model.User

interface UserRepository {
    suspend fun getContactList(page: Int): Result<List<User>>
}