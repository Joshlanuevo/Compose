//package com.vancoding.todo.navigation.destinations
//
//import androidx.navigation.NavGraphBuilder
//import androidx.navigation.compose.composable
//import com.vancoding.todo.ui.screens.splash.SplashScreen
//import com.vancoding.todo.utils.Constants.SPLASH_SCREEN
//
//fun NavGraphBuilder.splashComposable(
//    navigateToTaskScreen: () -> Unit,
//) {
//    composable(
//        route = SPLASH_SCREEN,
//    ) {
//        SplashScreen(
//            navigateToTaskScreen = navigateToTaskScreen,
//        )
//    }
//}