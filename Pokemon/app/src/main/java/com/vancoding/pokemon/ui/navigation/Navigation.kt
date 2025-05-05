package com.vancoding.pokemon.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.vancoding.pokemon.ui.navigation.destinations.detailComposable
import com.vancoding.pokemon.ui.navigation.destinations.listComposable
import com.vancoding.pokemon.viewmodel.PokemonViewModel

@Composable
fun SetupNavigation(
    navController: NavHostController,
    pokemonViewModel: PokemonViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = "pokemon_list",
    ) {
        listComposable(
            navigateToPokemonDetail = { id ->
                navController.navigate("pokemon_detail/$id")
            },
            pokemonViewModel = pokemonViewModel,
        )
        detailComposable(
            navigateBack = {
                navController.popBackStack()
            },
            pokemonViewModel = pokemonViewModel,
        )
    }
}