package com.vancoding.pokemon.data.remote.response

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class PokemonListResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonListItem>,
)

@Serializable
data class PokemonListItem(
    val name: String,
    val url: String,
    @Transient
    val id: Int = extractIdFromUrl(url)
) {
    companion object {
        // Function to extract the Pokemon ID from the URL
        // e.g., "https://pokeapi.co/api/v2/pokemon/1/" -> 1
        private fun extractIdFromUrl(url: String): Int {
            // Default value in case parsing fails
            return try {
                val segments = url.trim('/').split('/')
                segments.last { it.isNotEmpty() }.toInt()
            } catch (e: Exception) {
                0 // Default ID if extraction fails
            }
        }
    }
}
