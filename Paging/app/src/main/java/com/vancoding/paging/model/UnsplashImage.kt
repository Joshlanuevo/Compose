package com.vancoding.paging.model

import androidx.room.Embedded
import androidx.room.Entity
import com.vancoding.paging.utils.Constants.UNSPLASH_IMAGE_TABLE

@Entity(tableName = UNSPLASH_IMAGE_TABLE)
data class UnsplashImage(
    val id: String,
    @Embedded
    val urls: Urls,
    val likes: Int,
    @Embedded
    val user: User,
)
