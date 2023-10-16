package com.example.pokedex.data

import com.google.gson.annotations.SerializedName

data class PokemonesResponse (
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: String,
    @SerializedName("results")
    val results: List<PokemonList>
        )
