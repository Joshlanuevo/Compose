package com.vancoding.paging.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerializedName("links")
    val links: UserLinks,
    @SerializedName("username")
    val username: String,
)
