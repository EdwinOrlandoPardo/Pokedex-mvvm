package com.example.pokedexapplication.di

import com.example.pokedexapplication.data.ApiService.PokemonRequest
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("https://pokeapi.co/api/v2/")// base de la url
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providePokemonRequest(retrofit : Retrofit): PokemonRequest{
        return retrofit.create(PokemonRequest::class.java)
    }
}