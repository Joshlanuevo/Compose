package com.vancoding.userlist.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class UserResponseDto(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<UserDto>,
    val support: SupportDto,
)
