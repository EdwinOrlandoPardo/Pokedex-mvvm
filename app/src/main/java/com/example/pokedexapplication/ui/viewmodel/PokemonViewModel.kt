package com.example.pokedexapplication.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapplication.data.ApiService.PokemonService
import com.example.pokedexapplication.data.model.PokemonItemResponse
import kotlinx.coroutines.launch


class PokemonViewModel : ViewModel(){

    val pokemonList = MutableLiveData<List<PokemonItemResponse>>()
    var pokemonService = PokemonService()

    fun PokemonListViewModel(){
        viewModelScope.launch {
            val dataresult = pokemonService.getPokemonLsit()
            if (dataresult.isNotEmpty()){
                pokemonList.postValue(dataresult)
            }else{
                Log.i("edwin","pokelis Vacia")
            }
        }
    }
}