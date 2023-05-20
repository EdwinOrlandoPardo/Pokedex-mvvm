package com.example.pokedexapplication.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getRetroFit(): Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("https://pokeapi.co/api/v2/")// base de la url
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }


}