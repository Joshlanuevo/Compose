package com.vancoding.contactlistapp.utils

sealed class NetworkResultState<out T> {
    data class Success<T>(val data: T) : NetworkResultState<T>()
    data class Failure(val message: String) : NetworkResultState<Nothing>()
    object Default : NetworkResultState<Nothing>()
    object Loading : NetworkResultState<Nothing>()
}