package com.example.pokedex.data

import com.google.gson.annotations.SerializedName

data class MovesList (
    @SerializedName("move")
    val move: Moves,
    @SerializedName("version_group_details")
    val version_group_details: List<VersionGroupDetails>
        )