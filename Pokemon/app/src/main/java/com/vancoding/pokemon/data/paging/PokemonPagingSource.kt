package com.vancoding.pokemon.data.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.vancoding.pokemon.data.remote.api.PokemonApi
import com.vancoding.pokemon.data.remote.response.PokemonListItem
import retrofit2.HttpException
import java.io.IOException

class PokemonPagingSource(
    private val pokemonApi: PokemonApi,
): PagingSource<Int, PokemonListItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonListItem> {
        val currentPage = params.key ?: 1
        val limit = params.loadSize
        val offset = (currentPage - 1) * limit

        Log.d("PokemonPaging", "Fetching page=$currentPage with offset=$offset, limit=$limit")

        return try {
            val response = pokemonApi.getPokemonList(limit = limit, offset = offset)
            if (response.isSuccessful) {
                val results = response.body()?.results ?: emptyList()
                val endOfPagination = results.isEmpty()

                Log.d("PokemonPaging", "Fetched ${results.size} Pokémon")

                LoadResult.Page(
                    data = results,
                    prevKey = if (currentPage == 0) null else currentPage - 1,
                    nextKey = if (endOfPagination) null else currentPage + 1,
                )
            } else {
                Log.e("PokemonPaging", "HTTP error: ${response.code()}")
                LoadResult.Error(HttpException(response))
            }
        } catch (e: IOException) {
            Log.e("PokemonPaging", "IO Exception: ${e.message}")
            LoadResult.Error(e)
        } catch (e: HttpException) {
            Log.e("PokemonPaging", "HTTP Exception: ${e.message}")
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PokemonListItem>): Int? {
        return state.anchorPosition
    }
}