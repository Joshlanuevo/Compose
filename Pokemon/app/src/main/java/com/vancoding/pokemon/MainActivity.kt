package com.vancoding.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vancoding.pokemon.ui.navigation.SetupNavigation
import com.vancoding.pokemon.ui.theme.PokemonTheme
import com.vancoding.pokemon.viewmodel.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val pokemonViewModel: PokemonViewModel by viewModels()
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonTheme {
                Surface {
                    navController = rememberNavController()

                    SetupNavigation(
                        navController = navController,
                        pokemonViewModel = pokemonViewModel,
                    )
                }
            }
        }
    }
}