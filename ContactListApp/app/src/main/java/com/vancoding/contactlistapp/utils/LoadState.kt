package com.vancoding.contactlistapp.utils

sealed class LoadState<out T> {
    data class Success<T>(val data: T) : LoadState<T>()
    data class Failure(val message: String) : LoadState<Nothing>()
    object Default : LoadState<Nothing>()
    object Loading : LoadState<Nothing>()
}