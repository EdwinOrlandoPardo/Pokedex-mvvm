package com.example.pokedexapplication.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapplication.data.ApiService.PokemonService
import com.example.pokedexapplication.data.model.PokemonDataModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    val pokemonservice : PokemonService
) : ViewModel() {

    val pokemondetailList = MutableLiveData<PokemonDataModel>()


    fun pokemonDetailInfoViewmodel(name :String){
        viewModelScope.launch{
            val dataResult = pokemonservice.getPokemonDetail(name)
            if ( dataResult != null){
                pokemondetailList.postValue(dataResult)
            }else{
                Log.i("pardo","no hay datos")
            }
        }

    }


}