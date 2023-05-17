package com.example.pokedexapplication.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.pokedexapplication.data.model.PokemonItemResponse

class PokemonViewModel {

    private val pokemonList = MutableLiveData<List<PokemonItemResponse>>()
}