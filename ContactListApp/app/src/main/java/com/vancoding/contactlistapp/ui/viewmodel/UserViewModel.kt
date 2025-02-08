package com.vancoding.contactlistapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vancoding.contactlistapp.domain.model.UserPage
import com.vancoding.contactlistapp.domain.usecases.GetUserUseCase
import com.vancoding.contactlistapp.utils.LoadState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
): ViewModel() {

    private val _users = MutableStateFlow<LoadState<UserPage>>(LoadState.Default)
    val users: StateFlow<LoadState<UserPage>> = _users

    private var currentPage: Int = 0

    fun getContactList() {
        viewModelScope.launch {}
    }
}