package com.vancoding.contactlistapp.data.remote.api

import com.vancoding.contactlistapp.data.remote.config.ApiConfig
import com.vancoding.contactlistapp.data.remote.dto.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(ApiConfig.Endpoints.USERS)
    suspend fun getContactList(): Response<UserResponse>
}