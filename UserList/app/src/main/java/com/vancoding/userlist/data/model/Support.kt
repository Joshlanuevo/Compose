package com.vancoding.userlist.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Support(
    val url: String,
    val text: String,
)
