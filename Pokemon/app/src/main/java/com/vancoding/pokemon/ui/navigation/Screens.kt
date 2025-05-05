package com.vancoding.pokemon.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screens {
    @Serializable
    data object PokemonList : Screens()
    @Serializable
    data class PokemonDetail(val id: Int) : Screens()
}