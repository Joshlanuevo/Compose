package com.vancoding.pokemon.ui.navigation.destinations

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.vancoding.pokemon.ui.screens.PokemonDetailScreen
import com.vancoding.pokemon.viewmodel.PokemonViewModel

fun NavGraphBuilder.detailComposable(
    navigateBack: () -> Unit,
    pokemonViewModel: PokemonViewModel,
) {
    composable(
        route = "pokemon_detail/{id}",
        arguments = listOf(navArgument("id") { type = NavType.IntType })
    ) { backStackEntry ->
        val pokemonId = backStackEntry.arguments?.getInt("id") ?: 0

        // Load Pokemon details when screen is shown
        LaunchedEffect(key1 = pokemonId) {
            pokemonViewModel.getPokemonById(pokemonId)
        }

        PokemonDetailScreen(
            pokemonViewModel = pokemonViewModel,
            navigateBack = navigateBack,
        )
    }
}