package com.example.pokedexapplication.data.model

import com.google.gson.annotations.SerializedName

data class PokemonModelResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: Int,
    @SerializedName("previous") val previous: Int,
    @SerializedName("result") val result: List<PokemonItemResponse>
)

data class PokemonItemResponse(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)