package com.example.pokedex.network

import com.example.pokedex.data.PokemonResponse
import com.example.pokedex.data.PokemonesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface API {
    @GET("pokemon?limit=1500&offset=0")
    fun getPokemonList(): Call<PokemonesResponse>

    @GET("pokemon/{pokemonName}/")
    fun getPokemon(@Path("pokemonName") pokemonName:String): Call<PokemonResponse>
}