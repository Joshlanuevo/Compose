package com.vancoding.todo.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vancoding.todo.data.models.Priority
import com.vancoding.todo.data.models.ToDoTask
import com.vancoding.todo.data.repository.ToDoRepository
import com.vancoding.todo.utils.RequestState
import com.vancoding.todo.utils.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.vancoding.todo.utils.Constants.MAX_TITLE_LENGTH

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val todoRepository: ToDoRepository
) : ViewModel() {

    val id: MutableState<Int> = mutableIntStateOf(0)

    val title: MutableState<String> = mutableStateOf("")

    val description: MutableState<String> = mutableStateOf("")

    val priority: MutableState<Priority> = mutableStateOf(Priority.LOW)

    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)

    val searchTextState: MutableState<String> = mutableStateOf("")

    private val _allTasks = MutableStateFlow<RequestState<List<ToDoTask>>>(RequestState.Default)
    val allTasks: StateFlow<RequestState<List<ToDoTask>>> = _allTasks

    private val _selectedTask: MutableStateFlow<ToDoTask?> = MutableStateFlow(null)
    val selectedTask: StateFlow<ToDoTask?> = _selectedTask

    private val _isNewTask = MutableStateFlow(false)
    val isNewTask: StateFlow<Boolean> = _isNewTask

    fun getAllTasks() {
        _allTasks.value = RequestState.Loading
        try {
            viewModelScope.launch {
                todoRepository.getAllTasks.collect { tasks ->
                    _allTasks.value = RequestState.Success(tasks)
                }
            }
        } catch (e: Exception){
            _allTasks.value = RequestState.Failure(e)
        }
    }

    fun getSelectedTask(taskId: Int) {
        viewModelScope.launch {
            todoRepository.getSelectedTask(taskId = taskId).collect { task ->
                _selectedTask.value = task
            }
        }
    }

    fun updateTaskFields(selectedTask: ToDoTask?) {
        _isNewTask.value = selectedTask == null
        id.value = selectedTask?.id ?: 0
        title.value = selectedTask?.title ?: ""
        description.value = selectedTask?.description ?: ""
        priority.value = selectedTask?.priority ?: Priority.LOW
    }

    fun updateTitle(newTitle: String) {
        if (newTitle.length < MAX_TITLE_LENGTH) {
            title.value = newTitle
        }
    }
}