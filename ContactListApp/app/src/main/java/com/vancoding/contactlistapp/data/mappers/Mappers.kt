package com.vancoding.contactlistapp.data.mappers

import com.vancoding.contactlistapp.data.remote.dto.UserData
import com.vancoding.contactlistapp.domain.model.User

fun UserData.toDomainModel(): User {
    return User(
        id = this.id,
        email = this.email,
        firstName = this.first_name,
        lastName = this.last_name,
        avatar = this.avatar,
    )
}