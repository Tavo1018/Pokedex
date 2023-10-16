package com.example.pokedex.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.PokemonesResponse
import com.example.pokedex.domain.useCases.GetServiceUseCases
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonesViewModel(private val controller: Application): AndroidViewModel(controller){

    private val getServiceUseCases = GetServiceUseCases()
    var mutableLiveDataGetPokemones: MutableLiveData<Pair<Int,PokemonesResponse>>? = null

    fun pokemonesViewModel(){
        viewModelScope.launch {
            getServiceUseCases.invokeGetPokemones().enqueue(object : Callback<PokemonesResponse>{
                override fun onResponse(
                    call: Call<PokemonesResponse>,
                    response: Response<PokemonesResponse>
                ) {
                    mutableLiveDataGetPokemones!!.postValue(Pair(response.code(), response.body()!!))
                }

                override fun onFailure(call: Call<PokemonesResponse>, t: Throwable) {
                    mutableLiveDataGetPokemones!!.postValue(null)
                }
            })
        }
    }
}