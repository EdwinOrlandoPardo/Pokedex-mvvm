package com.example.pokedexapplication.data.ApiService

import android.util.Log
import com.example.pokedexapplication.core.RetrofitHelper
import com.example.pokedexapplication.data.model.PokemonApiResponse
import com.example.pokedexapplication.data.model.PokemonDataModel
import com.example.pokedexapplication.data.model.PokemonItemResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonService @Inject constructor(private val request:PokemonRequest) {

    suspend fun getPokemonLsit(): List<PokemonItemResponse> {
        val limit = 100
        val offset = 0
        return withContext(Dispatchers.IO) {
            val response = request.getListPokemon(limit, offset)
            if (!response.isSuccessful){
                Log.i("edwin","no hay nada")
            }
            response.body()!!.result?: emptyList()//si la lista es nula retorna una lista vacia
        }
    }


    suspend fun getPokemonDetail(name: String) : PokemonDataModel {
        return withContext(Dispatchers.IO) {
            val response = request.getDetailPokemon(name)
            Log.i("pardo", "${response.body()}")
            response.body()!!
        }
    }
}