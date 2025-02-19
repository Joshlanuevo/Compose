package com.vancoding.userlist.domain.model

data class UserResponse(
    val page: Int,
    val perPage: Int,
    val total: Int,
    val totalPages: Int,
    val users: List<User>,
    val support: Support,
)
