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
    private var isLoadingMore = false
    private var hasMorePages = true

    init {
        loadUsers()
    }

    private fun loadUsers() {
        if (isLoadingMore || !hasMorePages) return

        viewModelScope.launch {
            isLoadingMore = true

            usersUseCase(currentPage).onSuccess { response ->
                loadedUsers.addAll(response.users)
                hasMorePages = currentPage < response.totalPages

                _usersList.value = LoadState.Success(
                    data = loadedUsers,
                    canLoadMore = hasMorePages,
                )

                currentPage++
            }.onFailure {
                _usersList.value = LoadState.Failure(it)
            }

            isLoadingMore = false
        }
    }
}