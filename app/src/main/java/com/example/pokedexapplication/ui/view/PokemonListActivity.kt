package com.example.pokedexapplication.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokedexapplication.R
import com.example.pokedexapplication.databinding.ActivityPokemonListBinding

class PokemonListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=  ActivityPokemonListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}