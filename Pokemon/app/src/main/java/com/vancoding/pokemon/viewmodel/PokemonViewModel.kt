package com.vancoding.pokemon.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.vancoding.pokemon.data.remote.response.PokemonInfoResponse
import com.vancoding.pokemon.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository,
) : ViewModel() {

    val pokemonPagingFlow = pokemonRepository.getPokemonList()
        .cachedIn(viewModelScope)

    private val _selectedPokemon = MutableStateFlow<PokemonInfoResponse?>(null)
    val selectedPokemon: StateFlow<PokemonInfoResponse?> = _selectedPokemon

    fun getPokemonById(id: Int) {
        viewModelScope.launch {
            val detail = pokemonRepository.getPokemonDetail(id)
            _selectedPokemon.value = detail
        }
    }
}