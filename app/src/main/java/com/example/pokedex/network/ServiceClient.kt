package com.example.pokedex.network

import com.example.pokedex.core.Retrofit
import com.example.pokedex.data.PokemonResponse
import com.example.pokedex.data.PokemonesResponse
import retrofit2.Call

class ServiceClient() {
    private val retrofit = Retrofit.getRetrofit()

    fun getPokemones(): Call<PokemonesResponse> {
        return retrofit.create(API::class.java).getPokemonList()
    }

    fun getPokemon(pokemon: String): Call<PokemonResponse>{
        return retrofit.create(API::class.java).getPokemon(pokemon)
    }
}