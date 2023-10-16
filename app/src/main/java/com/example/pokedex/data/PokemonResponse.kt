package com.example.pokedex.data

import com.google.gson.annotations.SerializedName

data class PokemonResponse (
    @SerializedName("abilities")
    val abilities: List<AbilitiesList>,
    @SerializedName("base_experience")
    val base_experience: Int,
    @SerializedName("forms")
    val forms: List<FormsList>,
    @SerializedName("game_indices")
    val game_indices: List<GameIndicesList>,
    @SerializedName("height")
    val height: Int,
    @SerializedName("held_items")
    val held_items: List<HeldItemsList>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("location_area_encounters")
    val location_area_encounters: String,
    @SerializedName("moves")
    val moves: List<MovesList>,
    @SerializedName("name")
    val name: String,
    @SerializedName("order")
    val order: Int,
    @SerializedName("past_type")
    val past_type: List<PastType>,
    @SerializedName("species")
    val species: Species,
    @SerializedName("sprites")
    val sprites: Sprites,
    @SerializedName("stats")
    val stats: List<StatsList>,
    @SerializedName("types")
    val types: List<TypesList>,
    @SerializedName("weight")
    val weight: Int
        )