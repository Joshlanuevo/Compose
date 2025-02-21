package com.vancoding.userlist.ui.common

sealed class LoadState<out T> {
    data class Success<T>(
        val data: T,
        val canLoadMore: Boolean,
    ) : LoadState<T>()
    data class Failure(val error: Throwable) : LoadState<Nothing>()
    object Default : LoadState<Nothing>()
    object Loading : LoadState<Nothing>()
}