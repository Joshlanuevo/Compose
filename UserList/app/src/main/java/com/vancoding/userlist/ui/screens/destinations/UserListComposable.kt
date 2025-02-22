//package com.vancoding.userlist.ui.screens.destinations
//
//import androidx.navigation.NavGraphBuilder
//import androidx.navigation.compose.composable
//import com.vancoding.userlist.ui.navigation.Screen
//import com.vancoding.userlist.ui.screens.home.HomeScreen
//import com.vancoding.userlist.viewmodel.UserListViewModel
//
//fun NavGraphBuilder.userListComposable(
//    navigateToUserDetail: (Int) -> Unit,
//    userListViewModel: UserListViewModel,
//) {
//    composable<Screen.Home> {
//        HomeScreen(
//            navigateToUserDetail = navigateToUserDetail,
//            userListViewModel = userListViewModel,
//        )
//    }
//}