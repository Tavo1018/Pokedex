package com.example.pokedex.data

import com.example.pokedex.network.ServiceClient
import retrofit2.Call

class ServiceRepository() {
    val api = ServiceClient()

    fun getPokemones(): Call<PokemonesResponse>{
        return api.getPokemones()
    }

    fun getPokemon(pokemon: String): Call<PokemonResponse>{
        return api.getPokemon(pokemon)
    }
}