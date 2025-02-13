package com.vancoding.paging

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.vancoding.paging.navigation.SetupNavGraph
import com.vancoding.paging.screens.home.HomeViewModel
import com.vancoding.paging.ui.theme.PagingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PagingTheme {
                val navController = rememberNavController()
                SetupNavGraph(
                    navController = navController,
                    homeViewModel = homeViewModel,
                )
            }
        }
    }
}