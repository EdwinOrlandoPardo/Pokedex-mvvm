package com.example.pokedexapplication.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexapplication.R
import com.example.pokedexapplication.data.model.PokemonItemResponse

class PokemonListAdapter(
    var pokemonList: List<PokemonItemResponse> = emptyList()

) :
    RecyclerView.Adapter<PokemonListViewHolder>() {

    fun updateList(pokemonList: List<PokemonItemResponse>) {
        this.pokemonList = pokemonList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return PokemonListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        val item = pokemonList[position]
        holder.renderView(item)
    }
}