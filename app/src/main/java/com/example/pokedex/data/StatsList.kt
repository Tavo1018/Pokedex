package com.example.pokedex.data

import com.google.gson.annotations.SerializedName

data class StatsList (
    @SerializedName("base_stat")
    val base_stat: Int,
    @SerializedName("effort")
    val effort: Int,
    @SerializedName("stat")
    val stat: Stat
        )