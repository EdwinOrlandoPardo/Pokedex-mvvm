package com.example.pokedexapplication.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapplication.data.ApiService.PokemonService
import com.example.pokedexapplication.data.model.PokemonItemResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private var pokemonService : PokemonService
) : ViewModel(){

    val pokemonList = MutableLiveData<List<PokemonItemResponse>>()
    val progressbarIsLoading = MutableLiveData<Boolean>()


    fun PokemonListViewModel(){
        viewModelScope.launch {
            progressbarIsLoading.postValue(true)
            val dataresult = pokemonService.getPokemonLsit()
            if (dataresult.isNotEmpty()){
                pokemonList.postValue(dataresult)
                progressbarIsLoading.postValue(false)
            }else{
                Log.i("edwin","pokelis Vacia")
            }
        }
    }
}