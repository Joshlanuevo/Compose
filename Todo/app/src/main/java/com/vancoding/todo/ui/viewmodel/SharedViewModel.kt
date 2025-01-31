package com.vancoding.todo.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vancoding.todo.data.models.Priority
import com.vancoding.todo.data.models.ToDoTask
import com.vancoding.todo.data.repository.ToDoRepository
import com.vancoding.todo.utils.Action
import com.vancoding.todo.utils.RequestState
import com.vancoding.todo.utils.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.vancoding.todo.utils.Constants.MAX_TITLE_LENGTH
import kotlinx.coroutines.Dispatchers

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val todoRepository: ToDoRepository
) : ViewModel() {

    val action: MutableState<Action> = mutableStateOf(Action.NO_ACTION)

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

    private fun addTasks() {
        viewModelScope.launch(Dispatchers.IO) {
            val toDoTask = ToDoTask(
                title = title.value,
                description = description.value,
                priority = priority.value,
            )
            todoRepository.addTask(toDoTask)
        }
    }

    private fun updateTasks() {
        viewModelScope.launch(Dispatchers.IO) {
            val doDoTask = ToDoTask(
                id = id.value,
                title = title.value,
                description = description.value,
                priority = priority.value,
            )
            todoRepository.updateTask(doDoTask)
        }
    }

    fun handleDatabaseActions(action: Action) {
        when (action) {
            Action.ADD -> {
                addTasks()
            }
            Action.UPDATE -> {
                updateTasks()
            }
            Action.DELETE -> {}
            Action.DELETE_ALL -> {}
            Action.UNDO -> {}
            else -> {}
        }
        this.action.value = Action.NO_ACTION
    }

    fun updateTaskFields(selectedTask: ToDoTask?) {
        if (selectedTask != null) {
            id.value = selectedTask.id
            title.value = selectedTask.title
            description.value = selectedTask.description
            priority.value = selectedTask.priority
        } else {
            id.value = 0
            title.value = ""
            description.value = ""
            priority.value = Priority.LOW
        }
    }

    fun updateTitle(newTitle: String) {
        if (newTitle.length < MAX_TITLE_LENGTH) {
            title.value = newTitle
        }
    }

    fun validateFields(): Boolean {
        return title.value.isNotEmpty() && description.value.isNotEmpty()
    }
}