package com.vancoding.contactlistapp.data.model

import com.google.gson.annotations.SerializedName

data class SupportResponse(
    @SerializedName("url")
    val url: String,
    @SerializedName("text")
    val text: String,
)
