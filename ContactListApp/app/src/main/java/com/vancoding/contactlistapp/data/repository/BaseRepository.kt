package com.vancoding.contactlistapp.data.repository

import com.vancoding.contactlistapp.utils.NetworkResultState
import retrofit2.Response

abstract class BaseRepository {

    protected suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): NetworkResultState<T> {
        return try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    NetworkResultState.Success(body)
                } else {
                    NetworkResultState.Failure("Response body is null")
                }
            } else {
                NetworkResultState.Failure("Request failed with code ${response.code()}")
            }
        } catch (e: Exception) {
            NetworkResultState.Failure(e.message ?: "Unknown error occurred")
        }
    }
}