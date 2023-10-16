package com.example.pokedex.data

import com.google.gson.annotations.SerializedName

data class GenerationVI (
    @SerializedName("omegaruby-alphasapphire")
    val omegaruby_alphasapphire: OmegarubyAlphasapphire,
    @SerializedName("x-y")
    val x_y: XY
        )