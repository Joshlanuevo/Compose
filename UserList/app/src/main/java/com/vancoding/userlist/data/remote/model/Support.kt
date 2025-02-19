package com.vancoding.userlist.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class Support(
    val url: String,
    val text: String,
)
