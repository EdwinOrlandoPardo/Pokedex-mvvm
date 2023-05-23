package com.example.pokedexapplication.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.pokedexapplication.data.model.PokemonTypesResult
import com.example.pokedexapplication.databinding.ActivityPokemonDetailBinding
import com.example.pokedexapplication.ui.viewmodel.PokemonDetailViewModel
import com.squareup.picasso.Picasso

class PokemonDetailActivity : AppCompatActivity() {


    private lateinit var binding: ActivityPokemonDetailBinding
    private val pokemondetailviewmodel: PokemonDetailViewModel by viewModels()

    private lateinit var name: String

    companion object {
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {
        name = intent.getStringExtra(EXTRA_NAME).orEmpty()
        pokemonDetailInfo(name)
    }

    private fun pokemonDetailInfo(name: String) {

        pokemondetailviewmodel.pokemonDetailInfoViewmodel(name)
        pokemondetailviewmodel.pokemondetailList.observe(this, Observer {
            binding.txvNamePokemonDetail.text = it.name
            binding.txvAltura.text = it.heigth.toString()
            binding.txvPeso.text = it.weight.toString()
            Picasso.get().load(it.sprites.frontDefaul).into(binding.imgViewDetailPokemon)

            PokemonType(it.types)

        })

    }

    private fun PokemonType(types: List<PokemonTypesResult>){

        var result = ""

        val tipo = types.map { it.type.name }

        if (tipo.isNotEmpty()){
            for (it in tipo.indices) {
                if (it + 1 < tipo.size)
                    result += tipo.get(it) +" - "
                else{
                    result += tipo.get(it)
                }
            }
            binding.txvTipo1Pokemon.text = result

        }else{
            binding.txvTipo1Pokemon.text = "No tiene tipo"
        }
    }

}