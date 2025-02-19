package com.vancoding.userlist.data.remote.api

import com.vancoding.userlist.data.remote.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    @GET("users")
    suspend fun getContactList(
        @Query("page") page: Int,
    ) : Response<UserResponse>
}