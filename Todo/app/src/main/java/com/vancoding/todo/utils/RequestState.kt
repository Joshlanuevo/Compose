package com.vancoding.todo.utils

sealed class RequestState<out T> {
    data class Success<T>(val data: T) : RequestState<T>()
    data class Failure(val error: Throwable) : RequestState<Nothing>()
    object Default : RequestState<Nothing>()
    object Loading : RequestState<Nothing>()
}