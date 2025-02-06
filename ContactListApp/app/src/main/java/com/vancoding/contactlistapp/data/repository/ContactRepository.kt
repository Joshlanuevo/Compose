package com.vancoding.contactlistapp.data.repository

import com.vancoding.contactlistapp.data.remote.ResponseWrapper
import com.vancoding.contactlistapp.data.remote.api.ApiService
import com.vancoding.contactlistapp.data.remote.dto.UserResponse
import java.io.IOException
import javax.inject.Inject

class ContactRepository @Inject constructor(
    private val api: ApiService,
) {
    suspend fun getContactList(): ResponseWrapper<UserResponse> {
        return try {
            val response = api.getContactList()
            if (response.isSuccessful) {
                ResponseWrapper.ResponseSuccess(response.body())
            } else {
                ResponseWrapper.ResponseFailure(response.errorBody()?.string() ?: "Unknown error")
            }
        } catch (e: IOException) {
            ResponseWrapper.LocalNetworkError("Network error: ${e.message}")
        } catch (e: Exception) {
            ResponseWrapper.ResponseFailure("Unexpected error: ${e.message}")
        }
    }
}