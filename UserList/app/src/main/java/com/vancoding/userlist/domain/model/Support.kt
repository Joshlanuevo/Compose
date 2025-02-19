package com.vancoding.userlist.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Support(
    val url: String,
    val text: String,
)
