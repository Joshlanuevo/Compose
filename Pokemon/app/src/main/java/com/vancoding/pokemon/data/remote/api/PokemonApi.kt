package com.vancoding.pokemon.data.remote.api

import com.vancoding.pokemon.data.remote.response.PokemonInfoResponse
import com.vancoding.pokemon.data.remote.response.PokemonListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): Response<PokemonListResponse>

    @GET("pokemon/{id}")
    suspend fun getPokemonInfo(
        @Path("id") id: Int,
    ): Response<PokemonInfoResponse>

}