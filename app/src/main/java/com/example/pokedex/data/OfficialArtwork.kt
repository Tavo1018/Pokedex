package com.example.pokedex.data

import com.google.gson.annotations.SerializedName

data class OfficialArtwork (
        @SerializedName("front_default")
    val front_default: String?,
        @SerializedName("front_shiny")
    val front_shiny: String?
        )