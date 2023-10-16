package com.example.pokedex.data

import com.google.gson.annotations.SerializedName

data class TypesList(
    @SerializedName("slot")
    val slot: Int,
    @SerializedName("type")
    val type: Type
)