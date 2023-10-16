package com.example.pokedex.data

import com.google.gson.annotations.SerializedName

data class GameIndicesList (
    @SerializedName("game_index")
    val game_index: Int,
    @SerializedName("version")
    val version: Version
        )