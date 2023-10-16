package com.example.pokedex.core

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

object Retrofit {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}