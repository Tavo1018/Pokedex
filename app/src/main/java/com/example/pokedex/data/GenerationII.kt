package com.example.pokedex.data

import com.google.gson.annotations.SerializedName

data class GenerationII (
    @SerializedName("crystal")
    val crystal : Crystal,
    @SerializedName("gold")
    val gold: Gold,
    @SerializedName("silver")
    val silver: Silver
        )