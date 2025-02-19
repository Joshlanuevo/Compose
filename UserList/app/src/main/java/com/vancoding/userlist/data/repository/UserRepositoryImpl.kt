package com.vancoding.userlist.data.repository

import com.vancoding.userlist.data.remote.api.UserApi
import com.vancoding.userlist.data.remote.model.UserResponseDto
import retrofit2.Response
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApi,
) {

    suspend fun getContactList(page: Int): Response<UserResponseDto> {
        return api.getContactList(page)
    }
}