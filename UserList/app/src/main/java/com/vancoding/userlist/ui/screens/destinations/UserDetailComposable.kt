//package com.vancoding.userlist.ui.screens.destinations
//
//import androidx.navigation.NavGraphBuilder
//import androidx.navigation.compose.composable
//import androidx.navigation.toRoute
//import com.vancoding.userlist.ui.navigation.Screen
//import com.vancoding.userlist.ui.screens.user.UserDetailScreen
//import com.vancoding.userlist.utils.Action
//import com.vancoding.userlist.viewmodel.UserListViewModel
//
//fun NavGraphBuilder.userDetailComposable(
//    navigateBack: (Action) -> Unit,
//    userListViewModel: UserListViewModel,
//) {
//    composable<Screen.UserDetail> { navBackStackEntry ->
//        val userId = navBackStackEntry.toRoute<Screen.UserDetail>().userId
//
//        UserDetailScreen(
//            userId = navBackStackEntry.arguments?.getInt("userId") ?: 0,
//            navigateBack = navigateBack,
//            userListViewModel = userListViewModel,
//        )
//    }
//}