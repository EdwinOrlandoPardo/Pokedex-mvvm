package com.example.pokedexapplication.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedexapplication.databinding.ActivityPokemonListBinding
import com.example.pokedexapplication.ui.view.PokemonDetailActivity.Companion.EXTRA_NAME
import com.example.pokedexapplication.ui.viewmodel.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
        pokemonadapter = PokemonListAdapter{name -> goToDetailPokemon(name)}
        binding.rcvPokemonList.layoutManager = LinearLayoutManager(this)
        binding.rcvPokemonList.adapter = pokemonadapter
        progresBar()
    }

    private fun pokemonlist(){
        pokemonViewModel.PokemonListViewModel()
        pokemonViewModel.pokemonList.observe(this, Observer {list ->
            pokemonadapter.updateList(list)
        })

    }

    private fun progresBar(){
        pokemonViewModel.progressbarIsLoading.observe(this, Observer {
            binding.progres.isVisible = it
        })
    }

    private fun goToDetailPokemon(name : String){
        val intent = Intent(this,PokemonDetailActivity::class.java)
        intent.putExtra(EXTRA_NAME,name)
        startActivity(intent)
    }
}