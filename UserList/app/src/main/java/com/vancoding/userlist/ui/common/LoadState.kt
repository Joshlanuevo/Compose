package com.vancoding.userlist.ui.common

import com.vancoding.userlist.domain.model.User

sealed class LoadState<out T> {
    data class Success<T>(
        val data: List<User>,
        val canLoadMore: Boolean = true,
    ) : LoadState<T>()
    data class Failure(val error: Throwable) : LoadState<Nothing>()
    object Default : LoadState<Nothing>()
    object Loading : LoadState<Nothing>()
}