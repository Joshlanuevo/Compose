package com.vancoding.userlist.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<User>,
    val support: Support,
)
