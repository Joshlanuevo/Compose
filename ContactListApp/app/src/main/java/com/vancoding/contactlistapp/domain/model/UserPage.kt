package com.vancoding.contactlistapp.domain.model

data class UserPage(
    val users: List<User>,
    val currentPage: Int,
    val totalPages: Int,
    val totalUsers: Int,
)
