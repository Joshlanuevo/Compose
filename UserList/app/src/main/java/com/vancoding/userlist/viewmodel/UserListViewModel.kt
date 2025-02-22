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

    private val loadedUsers: MutableList<User> = mutableListOf()
    private var currentPage = 1
    private var canLoadMore = true
    private var isLoading = false

    init {
        loadUsers()
    }

    fun loadUsers() {
        if (!canLoadMore || isLoading) return

        viewModelScope.launch {
            isLoading = true

            if (currentPage == 1) {
                _usersList.value = LoadState.Loading
            }

            usersUseCase(currentPage).onSuccess { response ->
                loadedUsers.addAll(response.users)
                currentPage++
                canLoadMore = response.page < response.totalPages

                _usersList.value = LoadState.Success(
                    data = loadedUsers.toList(),
                    canLoadMore = canLoadMore
                )
            }.onFailure {
                _usersList.value = LoadState.Failure(it)
            }

            isLoading = false
        }
    }
}