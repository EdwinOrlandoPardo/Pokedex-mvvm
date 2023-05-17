package com.example.pokedexapplication.data.model

import com.google.gson.annotations.SerializedName

data class PokemonDataModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("height") val heigth: Int,
    @SerializedName("weight") val weight: Int,
    @SerializedName("types") val types: List<PokemonTypesResult>,
    @SerializedName("sprites") val sprites: Sprites
)

data class Sprites(
    @SerializedName("front_default") val frontDefaul: String?
)

data class PokemonTypesResult(
    @SerializedName("slot") val slot: Int,
    @SerializedName("type") val type: typePokemon
)

data class typePokemon(
    @SerializedName("name") val name: String,
)
