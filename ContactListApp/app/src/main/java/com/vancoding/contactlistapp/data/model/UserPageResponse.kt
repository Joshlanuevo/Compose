package com.vancoding.contactlistapp.data.model

import com.google.gson.annotations.SerializedName

data class UserPageResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val per_page: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("data")
    val data: List<UserResponse>,
    @SerializedName("support")
    val support: SupportResponse,
)
