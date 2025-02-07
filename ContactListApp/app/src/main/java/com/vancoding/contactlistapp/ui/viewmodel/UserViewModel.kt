package com.vancoding.contactlistapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.vancoding.contactlistapp.domain.model.User
import com.vancoding.contactlistapp.utils.LoadState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(

): ViewModel() {

    private val _users = MutableStateFlow<LoadState<List<User>>>(LoadState.Default)
    val users: StateFlow<LoadState<List<User>>> = _users

    fun getContactList() {}
}