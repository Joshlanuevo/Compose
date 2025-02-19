package com.vancoding.userlist.data.repository

import com.vancoding.userlist.data.remote.api.UserApi
import com.vancoding.userlist.domain.mapper.toDomain
import com.vancoding.userlist.domain.model.User
import com.vancoding.userlist.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApi,
): UserRepository {

    override suspend fun getContactList(page: Int): Result<List<User>> {
        return try {
            val response = api.getContactList(page)
            if (response.isSuccessful) {
                val userResponseDto = response.body()
                if (userResponseDto != null) {
                    Result.success(userResponseDto.toDomain())
                } else {
                    Result.failure(Exception("Response body is null"))
                }
            } else {
                Result.failure(Exception("API call failed with code: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}