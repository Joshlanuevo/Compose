package com.vancoding.userlist.ui.common

import com.vancoding.userlist.data.remote.model.UserDto

sealed class LoadState<out T> {
    data class Success<T>(
        val data: List<UserDto>,
        val canLoadMore: Boolean = true,
    ) : LoadState<T>()
    data class Failure(val error: Throwable) : LoadState<Nothing>()
    object Default : LoadState<Nothing>()
    object Loading : LoadState<Nothing>()
}