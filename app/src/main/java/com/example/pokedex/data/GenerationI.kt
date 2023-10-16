package com.example.pokedex.data

import com.google.gson.annotations.SerializedName

data class GenerationI (
    @SerializedName("red-blue")
    val red_blue: RedBlue,
    @SerializedName("yellow")
    val yellow: Yellow
        )