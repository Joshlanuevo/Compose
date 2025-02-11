package com.vancoding.paging.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vancoding.paging.model.UnsplashRemoteKeys

@Dao
interface UnsplashRemoteKeysDao {

    @Query("SELECT * FROM unsplash_remoteKeys_table WHERE id =:id")
    suspend fun getRemoteKeys(id: String): UnsplashRemoteKeys

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(remoteKeys: List<UnsplashRemoteKeys>)

    @Query("DELETE FROM unsplash_remoteKeys_table")
    suspend fun deleteAllRemoteKeys()
}