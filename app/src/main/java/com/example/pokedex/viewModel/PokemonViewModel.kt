package com.example.pokedex.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.PokemonResponse
import com.example.pokedex.domain.useCases.GetServiceUseCases
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonViewModel(private val controller: Application) : AndroidViewModel(controller) {
    private val getServiceUseCase = GetServiceUseCases()
    var mutableLiveDataPokemon: MutableLiveData<Pair<Int, PokemonResponse>>? = null

    fun pokemonViewModel(pokemon: String) {
        viewModelScope.launch {
            getServiceUseCase.invokeGetPokemon(pokemon).enqueue(object : Callback<PokemonResponse> {
                override fun onResponse(
                    call: Call<PokemonResponse>,
                    response: Response<PokemonResponse>
                ) {
                    if (response.isSuccessful){
                        mutableLiveDataPokemon!!.postValue(Pair(response.code(), response.body()!!))
                    }
                }

                override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                    mutableLiveDataPokemon!!.postValue(null)
                }

            })
        }
    }

}