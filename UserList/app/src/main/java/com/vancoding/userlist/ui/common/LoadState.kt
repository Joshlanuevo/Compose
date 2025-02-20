package com.vancoding.userlist.ui.common

sealed class LoadState {
    data class Success(val data: Any) : LoadState()
    data class Error(val message: String) : LoadState()
    object Default : LoadState()
    object Loading : LoadState()
}