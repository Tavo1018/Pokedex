package com.example.pokedex.data

import com.google.gson.annotations.SerializedName

data class BlackWhite (
    @SerializedName("animated")
    val animated: Animated,
    @SerializedName("back_default")
    val back_default: String?,
    @SerializedName("back_female")
    val back_female: String?,
    @SerializedName("back_shiny")
    val back_shiny: String?,
    @SerializedName("back_shiny_female")
    val back_shiny_female: String?,
    @SerializedName("front_default")
    val front_default: String?,
    @SerializedName("front_female")
    val front_female: String?,
    @SerializedName("front_shiny")
    val front_shiny: String?,
    @SerializedName("front_shiny_female")
    val front_shiny_female: String?
        )