package com.vancoding.paging.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vancoding.paging.data.local.dao.UnsplashImageDao
import com.vancoding.paging.data.local.dao.UnsplashRemoteKeysDao
import com.vancoding.paging.model.UnsplashImage
import com.vancoding.paging.model.UnsplashRemoteKeys

@Database(
    entities = [
        UnsplashImage::class,
        UnsplashRemoteKeys::class,
   ],
    version = 1,
)
abstract class UnsplashDatabase : RoomDatabase() {

    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao
}