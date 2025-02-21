package com.vancoding.userlist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vancoding.userlist.domain.model.User
import com.vancoding.userlist.domain.usecase.GetUsersUseCase
import com.vancoding.userlist.ui.common.LoadState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val usersUseCase: GetUsersUseCase,
): ViewModel() {

    private val _usersList = MutableStateFlow<LoadState<List<User>>>(LoadState.Default)
    val userList: StateFlow<LoadState<List<User>>> = _usersList

    private var currentPage = 1

    init {
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch {
            _usersList.value = LoadState.Loading

            usersUseCase(currentPage).onSuccess { response ->
                _usersList.value = LoadState.Success(
                    data = response.users,
                    canLoadMore = currentPage < response.totalPages
                )
            }.onFailure {
                _usersList.value = LoadState.Failure(it)
            }
        }
    }
}