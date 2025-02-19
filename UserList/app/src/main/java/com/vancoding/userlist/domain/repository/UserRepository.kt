package com.vancoding.userlist.domain.repository

interface UserRepository {
    suspend fun getContactList(page: Int):
}