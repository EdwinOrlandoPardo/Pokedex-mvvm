package com.example.pokedexapplication.data.ApiService

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeRequest {
    @GET("pokemon/{name}")
    suspend fun getDetailPokemon(@Path("name") pokemonName: String)

    @GET("pokemon")
    suspend fun getListPokemon(@Query("limit") limit: Int, @Query("offset") offset: Int)
}