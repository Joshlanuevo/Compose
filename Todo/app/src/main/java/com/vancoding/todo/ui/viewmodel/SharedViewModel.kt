package com.vancoding.todo.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vancoding.todo.data.models.Priority
import com.vancoding.todo.data.models.ToDoTask
import com.vancoding.todo.data.repository.DataStoreRepository
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
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val todoRepository: ToDoRepository,
    private val dataStoreRepository: DataStoreRepository,
) : ViewModel() {

    var action by mutableStateOf(Action.NO_ACTION)
        private set

    var id by mutableIntStateOf(0)
        private set

    var title by mutableStateOf("")
        private set

    var description by mutableStateOf("")
        private set

    var priority by mutableStateOf(Priority.LOW)
        private set

    var searchAppBarState by mutableStateOf(SearchAppBarState.CLOSED)
        private set

    var searchTextState by mutableStateOf("")
        private set

    private val _searchTasks = MutableStateFlow<RequestState<List<ToDoTask>>>(RequestState.Default)
    val searchTasks: StateFlow<RequestState<List<ToDoTask>>> = _searchTasks

    private val _allTasks = MutableStateFlow<RequestState<List<ToDoTask>>>(RequestState.Default)
    val allTasks: StateFlow<RequestState<List<ToDoTask>>> = _allTasks

    private val _selectedTask: MutableStateFlow<ToDoTask?> = MutableStateFlow(null)
    val selectedTask: StateFlow<ToDoTask?> = _selectedTask

    private val _sortState = MutableStateFlow<RequestState<Priority>>(RequestState.Default)
    val sortState: StateFlow<RequestState<Priority>> = _sortState

    val lowPriorityTasks: StateFlow<List<ToDoTask>> =
        todoRepository.sortByLowPriority.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            emptyList(),
        )

    val highPriorityTasks: StateFlow<List<ToDoTask>> =
        todoRepository.sortByHighPriority.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            emptyList(),
        )

    init {
        getAllTasks()
        readSortState()
    }

    private fun readSortState() {
        _sortState.value = RequestState.Loading
        try {
            viewModelScope.launch {
                dataStoreRepository.readSortState
                    .map { Priority.valueOf(it) }
                    .collect {
                        _sortState.value = RequestState.Success(it)
                    }
            }
        } catch (e: Exception){
            _sortState.value = RequestState.Failure(e)
        }
    }

    fun persistSortState(priority: Priority) {
        viewModelScope.launch(Dispatchers.IO) {
            dataStoreRepository.persisSortKey(priority = priority)
        }
    }

    fun searchDatabase(searchQuery: String) {
        _searchTasks.value = RequestState.Loading
        try {
            viewModelScope.launch {
                todoRepository.searchDatabase(searchQuery = "%${searchQuery}%")
                    .collect { searchedTasks ->
                        _searchTasks.value = RequestState.Success(searchedTasks)
                    }
            }
        } catch (e: Exception){
            _searchTasks.value = RequestState.Failure(e)
        }
        searchAppBarState = SearchAppBarState.TRIGGERED
    }

    private fun getAllTasks() {
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
                title = title,
                description = description,
                priority = priority,
            )
            todoRepository.addTask(toDoTask)
        }
        searchAppBarState = SearchAppBarState.CLOSED
    }

    private fun updateTasks() {
        viewModelScope.launch(Dispatchers.IO) {
            val doDoTask = ToDoTask(
                id = id,
                title = title,
                description = description,
                priority = priority,
            )
            todoRepository.updateTask(doDoTask)
        }
    }

    private fun deleteTasks() {
        viewModelScope.launch(Dispatchers.IO) {
            val doDoTask = ToDoTask(
                id = id,
                title = title,
                description = description,
                priority = priority,
            )
            todoRepository.deleteTask(doDoTask)
        }
    }

    private fun deleteAllTasks() {
        viewModelScope.launch(Dispatchers.IO) {
            todoRepository.deleteAllTasks()
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
            Action.DELETE -> {
                deleteTasks()
            }
            Action.DELETE_ALL -> {
                deleteAllTasks()
            }
            Action.UNDO -> {
                addTasks()
            }
            else -> {}
        }
    }

    fun updateTaskFields(selectedTask: ToDoTask?) {
        if (selectedTask != null) {
            id = selectedTask.id
            title = selectedTask.title
            description = selectedTask.description
            priority = selectedTask.priority
        } else {
            id = 0
            title = ""
            description = ""
            priority = Priority.LOW
        }
    }

    fun updateTitle(newTitle: String) {
        if (newTitle.length < MAX_TITLE_LENGTH) {
            title = newTitle
        }
    }

    fun updateAction(newAction: Action) {
        action = newAction
    }

    fun updateDescription(newDescription: String) {
        description = newDescription
    }

    fun updatePriority(newPriority: Priority) {
        priority = newPriority
    }

    fun updateAppBarState(newState: SearchAppBarState) {
        searchAppBarState = newState
    }

    fun updateSearchTextState(newState: String) {
        searchTextState = newState
    }

    fun validateFields(): Boolean {
        return title.isNotEmpty() && description.isNotEmpty()
    }
}