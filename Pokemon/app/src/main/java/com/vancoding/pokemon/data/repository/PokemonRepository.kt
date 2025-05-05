package com.vancoding.pokemon.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.vancoding.pokemon.data.paging.PokemonPagingSource
import com.vancoding.pokemon.data.remote.api.PokemonApi
import com.vancoding.pokemon.data.remote.response.PokemonInfoResponse
import com.vancoding.pokemon.data.remote.response.PokemonListItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonApi: PokemonApi,
) {

    fun getPokemonList(): Flow<PagingData<PokemonListItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false,
            ),
            pagingSourceFactory = { PokemonPagingSource(pokemonApi) }
        ).flow
    }

    suspend fun getPokemonDetail(id: Int): PokemonInfoResponse? {
        val response = pokemonApi.getPokemonInfo(id)
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}