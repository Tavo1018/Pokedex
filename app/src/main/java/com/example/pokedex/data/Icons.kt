package com.example.pokedex.data

import com.google.gson.annotations.SerializedName

data class Icons(
    @SerializedName("front_default")
    val front_default: String?,
    @SerializedName("front_female")
    val front_female: String?,
)