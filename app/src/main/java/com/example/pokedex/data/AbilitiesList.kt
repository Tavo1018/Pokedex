package com.example.pokedex.data

import com.google.gson.annotations.SerializedName

data class AbilitiesList (
    @SerializedName("ability")
    val ability: Ability,
    @SerializedName("is_hidden")
    val is_hidden: Boolean,
    @SerializedName("slot")
    val slot: Int
        )