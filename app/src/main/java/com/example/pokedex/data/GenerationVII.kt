package com.example.pokedex.data

import com.google.gson.annotations.SerializedName

data class GenerationVII (
    @SerializedName("icons")
    val icons : Icons,
    @SerializedName("ultra-sun-ultra-moon")
    val ultra_sun_ultra_moon: UltraSunUltraMoon
        )