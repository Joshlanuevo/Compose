package com.vancoding.paging.model

import androidx.room.Embedded
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("links")
    @Embedded
    val links: UserLinks,
    @SerialName("username")
    val username: String,
)
