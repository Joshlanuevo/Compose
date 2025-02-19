package com.vancoding.userlist.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.vancoding.userlist.data.remote.model.UserDto
import com.vancoding.userlist.ui.common.UserList

@Composable
fun HomeScreen(
    navController: NavHostController,
) {
    val users = listOf(
        UserDto(
            id = 1,
            email = "john.doe@example.com",
            first_name = "John",
            last_name = "Doe",
            avatar = "",
        ),
        UserDto(
            id = 2,
            email = "jane.doe@example.com",
            first_name = "Jane",
            last_name = "Doe",
            avatar = "",
        ),
        UserDto(
            id = 3,
            email = "bob.smith@example.com",
            first_name = "Bob",
            last_name = "Smith",
            avatar = "",
        ),
    )

    Scaffold(
        topBar = {
            HomeTopAppBar(
                onSearchedClick = {},
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(MaterialTheme.colorScheme.background),
                contentAlignment = Alignment.Center,
            ) {
                UserList(
                    users = users,
                    onItemClick = { user ->
                        println("Clicked on user: ${user.first_name}")
                    },
                )
            }
        }
    )
}