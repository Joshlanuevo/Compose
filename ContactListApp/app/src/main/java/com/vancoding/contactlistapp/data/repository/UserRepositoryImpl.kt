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
): BaseRepository(), UserRepository {
    override suspend fun getContactList(page: Int): NetworkResultState<UserPage> {
        return safeApiCall {
            api.getContactList(page)
        }.let { result ->
            when (result) {
                is NetworkResultState.Success -> {
                    val userPage = userMapper.mapToDomain(result.data)
                    NetworkResultState.Success(userPage)
                }
                is NetworkResultState.Failure -> result
                else -> NetworkResultState.Failure("Unknown error")
            }
        }
    }
}