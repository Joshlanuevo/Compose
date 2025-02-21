package com.vancoding.userlist.domain.mapper

import com.vancoding.userlist.data.remote.model.SupportDto
import com.vancoding.userlist.data.remote.model.UserResponseDto
import com.vancoding.userlist.domain.model.Support
import com.vancoding.userlist.data.remote.model.UserDto as RemoteUSer
import com.vancoding.userlist.domain.model.User
import com.vancoding.userlist.domain.model.UserResponse

fun RemoteUSer.toDomain(): User {
    return User(
        id = this.id,
        email = this.email,
        firstName = this.first_name,
        lastName = this.last_name,
        avatarUrl = this.avatar
    )
}

fun UserResponseDto.toDomain(): UserResponse {
    return UserResponse(
        page = this.page,
        perPage = this.per_page,
        total = this.total,
        totalPages = this.total_pages,
        users = this.data.map { it.toDomain() },
        support = this.support.toDomain(),
    )
}

fun SupportDto.toDomain(): Support {
    return Support(
        url = this.url,
        text = this.text
    )
}