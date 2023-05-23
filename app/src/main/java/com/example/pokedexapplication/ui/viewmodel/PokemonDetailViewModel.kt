package com.example.pokedexapplication.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapplication.data.ApiService.PokemonService
import com.example.pokedexapplication.data.model.PokemonDataModel
import kotlinx.coroutines.launch

class PokemonDetailViewModel : ViewModel() {

    val pokemondetailList = MutableLiveData<PokemonDataModel>()
    val pokemonservice = PokemonService()

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