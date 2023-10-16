package com.example.pokedex.data

import com.google.gson.annotations.SerializedName

data class RubySapphire (
        @SerializedName("back_default")
        val back_default: String?,
        @SerializedName("back_shiny")
        val back_shiny: String?,
        @SerializedName("front_default")
        val front_default: String?,
        @SerializedName("front_shiny")
        val front_shiny: String?
        )