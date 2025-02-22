package com.vancoding.userlist.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.vancoding.userlist.data.remote.model.UserDto
import com.vancoding.userlist.ui.common.LoadState
import com.vancoding.userlist.ui.common.UserItem
import com.vancoding.userlist.ui.common.UserList
import com.vancoding.userlist.viewmodel.UserListViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeScreen(
    navigateToUserDetail: (Int) -> Unit,
    userListViewModel: UserListViewModel,
) {

    val userListState by userListViewModel.userList.collectAsState()
    val listState = rememberLazyListState()

    LaunchedEffect(listState) {
        snapshotFlow { listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
            .collectLatest { lastVisibleIndex ->
                val totalItems = (userListState as? LoadState.Success)?.data?.size ?: 0
                if (lastVisibleIndex != null && lastVisibleIndex >= totalItems - 2 && (userListState as? LoadState.Success)?.canLoadMore == true) {
                    userListViewModel.loadUsers()
                }
            }
    }

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
                when (val state = userListState) {
                    is LoadState.Loading -> {
                        CircularProgressIndicator()
                    }
                    is LoadState.Success -> {
                        LazyColumn(state = listState) {
                            items(state.data.size) { index ->
                                UserItem(
                                    user = state.data[index],
                                    onItemClick = {
                                        navigateToUserDetail(state.data[index].id)
                                    },
                                )
                            }

                            // Show loading indicator at the bottom when loading more users
                            if (state.canLoadMore) {
                                item {
                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.Center,
                                    ) {
                                        CircularProgressIndicator()
                                    }
                                }
                            }
                        }
                    }
                    is LoadState.Failure -> {
                        Text("Error: ${state.error.message}")
                    }
                    is LoadState.Default -> {
                        Text("No users loaded")
                    }
                }
            }
        }
    )
}