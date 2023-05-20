package com.example.pokedexapplication.ui.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexapplication.data.model.PokemonItemResponse
import com.example.pokedexapplication.databinding.ItemPokemonBinding
import com.squareup.picasso.Picasso
import java.net.URL

class PokemonListViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    private val bindin = ItemPokemonBinding.bind(view)


    fun renderView(pokemoitemresponse : PokemonItemResponse){
        bindin.txvNamePokemon.text = pokemoitemresponse.name
        //bindin.root.setOnClickListener { onitemSelected(pokemoitemresponse.name) }

        leerURL(pokemoitemresponse.url)
        Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+ leerURL(pokemoitemresponse.url) +".png")
            .into(bindin.imgViewPokemon)

    }

    private fun leerURL(url : String) : Int{
        val result = URL(url)
        val path = result.path
        val split = path.split("/")
        val finalist = split.filter { it.isNotBlank()}

        return finalist.last().toInt()

    }

}