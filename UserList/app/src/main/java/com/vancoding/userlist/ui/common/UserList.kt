package com.vancoding.userlist.ui.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vancoding.userlist.data.remote.model.UserDto

@Composable
fun UserList(
    users: List<UserDto>,
    onItemClick: (UserDto) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(users) { user ->
            UserItem(
                user = user,
                onItemClick = onItemClick,
            )
        }
    }
}