package com.vancoding.todo.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vancoding.todo.data.models.ToDoTask
import com.vancoding.todo.data.repository.ToDoRepository
import com.vancoding.todo.utils.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val todoRepository: ToDoRepository
) : ViewModel() {

    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)

    val searchTextState: MutableState<String> = mutableStateOf("")

    private val _allTasks = MutableStateFlow<List<ToDoTask>>(emptyList())
    val allTasks: StateFlow<List<ToDoTask>> = _allTasks

    fun getAllTasks() {
        viewModelScope.launch {
            todoRepository.getAllTasks.collect {
                _allTasks.value = it
            }
        }
    }
}