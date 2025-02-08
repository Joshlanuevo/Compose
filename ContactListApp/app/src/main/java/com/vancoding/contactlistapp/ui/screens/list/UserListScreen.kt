package com.vancoding.contactlistapp.ui.screens.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.vancoding.contactlistapp.domain.model.User
import com.vancoding.contactlistapp.domain.model.UserPage
import com.vancoding.contactlistapp.ui.viewmodel.UserViewModel
import com.vancoding.contactlistapp.utils.LoadState

@Composable
fun UserListScreen(
    viewModel: UserViewModel,
) {
    val usersState by viewModel.users.collectAsState()

    when (val state = usersState) {
        is LoadState.Default -> {
            // Initial state, perhaps show a placeholder or nothing
            Text("Pull to refresh or load users")
        }
        is LoadState.Loading -> {
            // Show a loading indicator
            CircularProgressIndicator()
        }
        is LoadState.Success -> {
            // Display the list of users
            UserList(userPage = state.data)
        }
        is LoadState.Failure -> {
            // Show an error message
            Text("Error: ${state.message}")
        }
    }

    // Trigger the data loading when the screen is first displayed
    LaunchedEffect(Unit) {
        viewModel.getContactList()
    }
}

@Composable
fun UserList(userPage: UserPage) {
    LazyColumn {
        items(userPage.users) { user ->
            UserItem(user = user)
        }
    }
}

@Composable
fun UserItem(user: User) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = user.first_name, fontWeight = FontWeight.Bold)
            Text(text = user.email)
        }
    }
}