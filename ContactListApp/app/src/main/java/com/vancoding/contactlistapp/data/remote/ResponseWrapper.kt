package com.vancoding.contactlistapp.data.remote

sealed class ResponseWrapper<out T> {
    data class ResponseSuccess<out T>(val data: T?) : ResponseWrapper<T>()
    data class ResponseFailure(val message: String) : ResponseWrapper<Nothing>()
    data class LocalNetworkError(val message: String) : ResponseWrapper<Nothing>()
}