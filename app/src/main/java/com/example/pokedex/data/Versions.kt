package com.example.pokedex.data

import com.google.gson.annotations.SerializedName

data class Versions (
    @SerializedName("generation-i")
    val generation_i: GenerationI,
    @SerializedName("generation-ii")
    val generation_ii: GenerationII,
    @SerializedName("generation-iii")
    val generation_iii: GenerationIII,
    @SerializedName("generation-iv")
    val generation_iv: GenerationIV,
    @SerializedName("generation-v")
    val generation_v: GenerationV,
    @SerializedName("generation-vi")
    val generation_vi: GenerationVI,
    @SerializedName("generation-vii")
    val generation_vii: GenerationVII,
    @SerializedName("generation-viii")
    val generation_viii: GenerationVIII,
        )