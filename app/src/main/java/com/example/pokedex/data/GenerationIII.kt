package com.example.pokedex.data

import com.google.gson.annotations.SerializedName

data class GenerationIII(
    @SerializedName("emerald")
    val emerald: Emerald,
    @SerializedName("firered-leafgreen")
    val firered_leafgreen: FireredLeafgreen,
    @SerializedName("ruby-sapphire")
    val ruby_sapphire: RubySapphire
)