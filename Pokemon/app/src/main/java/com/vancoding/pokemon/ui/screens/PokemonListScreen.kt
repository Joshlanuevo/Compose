package com.vancoding.pokemon.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.vancoding.pokemon.ui.components.PokemonListItem
import com.vancoding.pokemon.viewmodel.PokemonViewModel

@Composable
fun PokemonListScreen(
    pokemonViewModel: PokemonViewModel,
    navigateToPokemonDetail: (id: Int) -> Unit,
) {
    val pokemonItems = pokemonViewModel.pokemonPagingFlow.collectAsLazyPagingItems()

    LazyColumn {
        items(pokemonItems.itemCount) { index ->
            val pokemon = pokemonItems[index]
            if (pokemon != null) {
                PokemonListItem(
                    pokemon = pokemon,
                    onPokemonClick = { navigateToPokemonDetail(pokemon.id) },
                )
            }
        }

        // Handle loading more items
        pokemonItems.apply {
            when {
                loadState.append is LoadState.Loading -> {
                    item { LoadingItem() }
                }
                loadState.append is LoadState.Error -> {
                    val e = loadState.append as LoadState.Error
                    item {
                        ErrorItem(message = e.error.localizedMessage ?: "Unknown error")
                    }
                }
            }
        }
    }
}

@Composable
fun LoadingItem() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorItem(message: String) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Error: $message",
            color = Color.Red,
        )
    }
}