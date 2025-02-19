package com.vancoding.userlist.data.repository

import com.vancoding.userlist.data.remote.api.UserApi
import com.vancoding.userlist.model.UserResponse
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: UserApi,
) {

    suspend fun getContactList(page: Int): Response<UserResponse> {
        return api.getContactList(page)
    }
}