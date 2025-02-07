package com.vancoding.contactlistapp.domain.repository

import com.vancoding.contactlistapp.domain.model.UserPage

interface UserRepository {
    suspend fun getContactList(page: Int): Result<UserPage>
}