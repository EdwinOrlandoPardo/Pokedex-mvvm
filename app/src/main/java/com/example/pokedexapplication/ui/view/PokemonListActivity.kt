package com.example.pokedexapplication.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedexapplication.R
import com.example.pokedexapplication.databinding.ActivityPokemonListBinding
import com.example.pokedexapplication.ui.viewmodel.PokemonViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class PokemonListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonListBinding

    private val pokemonViewModel : PokemonViewModel by viewModels()
    private lateinit var pokemonadapter: PokemonListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=  ActivityPokemonListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()
    }

    private fun initUi() {
        pokemonlist()
        pokemonadapter = PokemonListAdapter()
        binding.rcvPokemonList.layoutManager = LinearLayoutManager(this)
        binding.rcvPokemonList.adapter = pokemonadapter
    }

    private fun pokemonlist(){
        pokemonViewModel.PokemonListViewModel()
        pokemonViewModel.pokemonList.observe(this, Observer {list ->
            pokemonadapter.updateList(list)
        })

    }
}