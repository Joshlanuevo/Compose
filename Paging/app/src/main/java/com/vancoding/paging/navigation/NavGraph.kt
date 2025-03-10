package com.vancoding.paging.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vancoding.paging.screens.home.HomeScreen
import com.vancoding.paging.screens.home.HomeViewModel
import com.vancoding.paging.screens.search.SearchScreen
import com.vancoding.paging.screens.search.SearchViewModel

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    homeViewModel: HomeViewModel,
    searchViewModel: SearchViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                navController = navController,
                homeViewModel = homeViewModel,
            )
        }
        composable(route = Screen.Search.route) {
            SearchScreen(
                navController = navController,
                searchViewModel = searchViewModel,
            )
        }
    }
}