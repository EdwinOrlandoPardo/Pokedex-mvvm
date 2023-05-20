package com.example.pokedexapplication.data.model

import com.google.gson.annotations.SerializedName

data class PokemonApiResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: String,
    @SerializedName("results") val result: List<PokemonItemResponse>
)

data class PokemonItemResponse(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)