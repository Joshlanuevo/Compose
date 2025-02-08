package com.vancoding.contactlistapp.data.repository

import com.vancoding.contactlistapp.data.mapper.UserMapper
import com.vancoding.contactlistapp.data.remote.api.ApiService
import com.vancoding.contactlistapp.domain.model.UserPage
import com.vancoding.contactlistapp.domain.repository.UserRepository
import com.vancoding.contactlistapp.utils.NetworkResultState
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val userMapper: UserMapper,
): UserRepository {
    override suspend fun getContactList(page: Int): NetworkResultState<UserPage> {
        return try {
            val response = api.getContactList(page)
            if (response.isSuccessful) {
                val userPage = response.body()?.let { userMapper.mapToDomain(it) }
                if (userPage != null) {
                    NetworkResultState.Success(userPage)
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