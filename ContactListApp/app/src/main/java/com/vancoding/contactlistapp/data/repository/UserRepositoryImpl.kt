package com.vancoding.contactlistapp.data.repository

import com.vancoding.contactlistapp.data.mappers.toDomainModel
import com.vancoding.contactlistapp.data.remote.ResponseWrapper
import com.vancoding.contactlistapp.data.remote.api.ApiService
import com.vancoding.contactlistapp.data.remote.dto.UserResponse
import com.vancoding.contactlistapp.domain.model.User
import com.vancoding.contactlistapp.domain.repository.UserRepository
import java.io.IOException
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: ApiService,
) : UserRepository {
    override suspend fun getContactList(): ResponseWrapper<List<User>> {
        return try {
            val response = api.getContactList()
            if (response.isSuccessful) {
                val userResponse = response.body()
                userResponse?.data?.let {
                    val users = it.map { userData -> userData.toDomainModel() }
                    ResponseWrapper.ResponseSuccess(users)
                } ?: ResponseWrapper.ResponseFailure("No data found")
            } else {
                ResponseWrapper.ResponseFailure(response.errorBody()?.string() ?: "API Error")
            }
        } catch (e: IOException) {
            ResponseWrapper.LocalNetworkError(e.message ?: "Network Error")
        } catch (e: Exception) {
            ResponseWrapper.ResponseFailure(e.message ?: "Unknown Error")
        }
    }
}