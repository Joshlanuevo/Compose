package com.vancoding.pokemon.ui.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.vancoding.pokemon.ui.navigation.Screens
import com.vancoding.pokemon.ui.screens.PokemonListScreen
import com.vancoding.pokemon.viewmodel.PokemonViewModel

fun NavGraphBuilder.listComposable(
    navigateToPokemonDetail: (id: Int) -> Unit,
    pokemonViewModel: PokemonViewModel,
) {
    composable(
        route = "pokemon_list"
    ) {
        PokemonListScreen(
            pokemonViewModel = pokemonViewModel,
            navigateToPokemonDetail = navigateToPokemonDetail,
        )
    }
}