package com.vancoding.userlist.domain.mapper

import com.vancoding.userlist.data.remote.model.UserResponseDto
import com.vancoding.userlist.data.remote.model.UserDto as RemoteUSer
import com.vancoding.userlist.domain.model.User

fun RemoteUSer.toDomain(): User {
    return User(
        id = this.id,
        email = this.email,
        firstName = this.first_name,
        lastName = this.last_name,
        avatarUrl = this.avatar
    )
}

fun UserResponseDto.toDomain(): List<User> {
    return this.data.map { it.toDomain() }
}