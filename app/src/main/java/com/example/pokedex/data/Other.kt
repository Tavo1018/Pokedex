package com.example.pokedex.data

import com.google.gson.annotations.SerializedName

data class Other (
    @SerializedName("dream_worl")
    val dream_worl: DreamWorld,
    @SerializedName("home")
    val home: Home,
    @SerializedName("official_artwork")
    val official_artwork: OfficialArtwork
        )