package com.vancoding.paging.screens.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.vancoding.paging.screens.common.ListContent

@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel,
) {
    val searchQuery by searchViewModel.searchQuery
    val searchedImages = searchViewModel.searchedImages.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            SearchWidget(
                text = searchQuery,
                onTextChange = {
                    searchViewModel.updateSearchQuery(query = it)
                },
                onSearchClicked = {
                    searchViewModel.searchHeroes(query = it)
                },
                onCloseClicked = {
                    navController.popBackStack()
                }
            )
        },
        content = { contentPadding ->
            Box(
                modifier = Modifier.padding(contentPadding),
            ) {
                ListContent(items = searchedImages)
            }
        }
    )
}