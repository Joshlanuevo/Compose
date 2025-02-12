package com.vancoding.paging.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object Search : Screen("search_screen")
    object Details : Screen("details_screen/{imageId}")
}