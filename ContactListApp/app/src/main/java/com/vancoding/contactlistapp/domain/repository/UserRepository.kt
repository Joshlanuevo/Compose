package com.vancoding.contactlistapp.domain.repository

import com.vancoding.contactlistapp.data.remote.ResponseWrapper
import com.vancoding.contactlistapp.domain.model.User

interface UserRepository {
    suspend fun getContactList(): ResponseWrapper<List<User>>
}