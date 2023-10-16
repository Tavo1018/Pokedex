package com.example.pokedex.data

import com.google.gson.annotations.SerializedName

data class GenerationIV (
    @SerializedName("diamond-pearl")
    val diamond_pearl: DiamondPearl,
    @SerializedName("heartgold-soulsilver")
    val heartgold_soulsilver: HeartGoldSoulSilver,
    @SerializedName("platinum")
    val platinum: Platinum
        )