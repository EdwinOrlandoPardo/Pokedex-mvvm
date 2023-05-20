package com.example.pokedexapplication.data.ApiService

import android.util.Log
import com.example.pokedexapplication.core.RetrofitHelper
import com.example.pokedexapplication.data.model.PokemonApiResponse
import com.example.pokedexapplication.data.model.PokemonItemResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonService {

    private val retrofit = RetrofitHelper.getRetroFit()

    suspend fun getPokemonLsit():  List<PokemonItemResponse> {
        //val listaPokemon: List<PokemonItemResponse>
        val limit = 100
        val offset = 0
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(PokemonRequest::class.java).getListPokemon(limit, offset)
            Log.i("edwin", "${response.body()}")
            response.body()!!.result
        }
    }
}