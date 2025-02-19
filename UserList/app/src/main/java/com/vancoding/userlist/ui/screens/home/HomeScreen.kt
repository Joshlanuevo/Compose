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
import com.vancoding.userlist.data.model.User
import com.vancoding.userlist.ui.common.UserList

@Composable
fun HomeScreen(
    navController: NavHostController,
) {
    val users = listOf(
        User("Alice"),
        User("Bob"),
        User("Charlie"),
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
                        println("Clicked on user: ${user.name}")
                    },
                )
            }
        }
    )
}