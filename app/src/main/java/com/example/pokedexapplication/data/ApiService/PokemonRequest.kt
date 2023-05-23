package com.example.pokedexapplication.data.ApiService

import com.example.pokedexapplication.data.model.PokemonDataModel
import com.example.pokedexapplication.data.model.PokemonApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonRequest {
    @GET("pokemon/{name}") // URL
    suspend fun getDetailPokemon(@Path("name") pokeName: String) : Response<PokemonDataModel>

    @GET("pokemon")
    suspend fun getListPokemon(@Query("limit") limit: Int, @Query("offset") offset: Int) : Response<PokemonApiResponse>
}