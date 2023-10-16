package com.example.pokedex.domain.useCases

import com.example.pokedex.data.PokemonResponse
import com.example.pokedex.data.PokemonesResponse
import com.example.pokedex.data.ServiceRepository
import retrofit2.Call

class GetServiceUseCases() {
    val serviceRepository = ServiceRepository()

    fun invokeGetPokemones():Call<PokemonesResponse>{
        return serviceRepository.getPokemones()
    }

    fun invokeGetPokemon(pokemon: String): Call<PokemonResponse>{
        return serviceRepository.getPokemon(pokemon)
    }
}