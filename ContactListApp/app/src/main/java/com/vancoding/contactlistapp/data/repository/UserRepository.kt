package com.vancoding.contactlistapp.data.repository

import com.vancoding.contactlistapp.data.mapper.UserMapper
import com.vancoding.contactlistapp.data.remote.api.ApiService
import com.vancoding.contactlistapp.domain.model.UserPage
import com.vancoding.contactlistapp.domain.repository.UserRepository
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: ApiService,
    private val userMapper: UserMapper,
): UserRepository {
    override suspend fun getContactList(page: Int): Result<UserPage> = try {
        val response = api.getContactList(page)
        if (response.isSuccessful) {
            val userPage = response.body()?.let { userMapper.mapToDomain(it) }
            if (userPage != null) {
                Result.success(userPage)
            } else {
                Result.failure(Exception("Response body is null"))
            }
        } else {
            Result.failure(Exception("Request failed with code ${response.code()}"))
        }
    } catch (e: Exception) {
        Result.failure(e)
    }
}