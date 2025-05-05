package com.vancoding.pokemon.data.remote.api.config

object PokemonApiConfig {

    const val BASE_URL = "https://pokeapi.co/api/v2/"
    const val TIMEOUT_SECONDS = 15L

    object EndPoints {
        const val POKEMON_LIST = "pokemon"
        const val POKEMON_DETAILS = "pokemon/{id}"
    }
}