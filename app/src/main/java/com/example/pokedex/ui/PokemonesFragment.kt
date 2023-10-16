package com.example.pokedex.ui

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.MainActivity
import com.example.pokedex.R
import com.example.pokedex.data.PokemonResponse
import com.example.pokedex.data.PokemonesResponse
import com.example.pokedex.databinding.FragmentPokemonesBinding
import com.example.pokedex.ui.adapters.AdapterPokemones
import com.example.pokedex.ui.adapters.InterfacePokemon
import com.example.pokedex.viewModel.PokemonViewModel
import com.example.pokedex.viewModel.PokemonesViewModel

class PokemonesFragment : Fragment(), InterfacePokemon  {

    private var _binding: FragmentPokemonesBinding? = null
    private val binding get() = _binding!!
    private var mutableLiveDataGetPokemones: MutableLiveData<Pair<Int, PokemonesResponse>>? = null
    private var mutableLiveDataGetPokemon: MutableLiveData<Pair<Int,PokemonResponse>>? = null
    private val pokemonesViewModel: PokemonesViewModel by viewModels()
    private val pokemonViewModel: PokemonViewModel by viewModels()

    private var pokemonList: ArrayList<PokemonResponse> = arrayListOf()
    private lateinit var pokemonAdapter: AdapterPokemones

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPokemones()
        pokemonAdapter = AdapterPokemones(pokemonList, requireContext(), this)
        binding.rvPokemones.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvPokemones.adapter = pokemonAdapter
    }

    private fun getPokemones(){
        mutableLiveDataGetPokemones = MutableLiveData<Pair<Int, PokemonesResponse>>()
        pokemonesViewModel.mutableLiveDataGetPokemones = mutableLiveDataGetPokemones
        pokemonesViewModel.pokemonesViewModel()
        pokemonesViewModel.mutableLiveDataGetPokemones!!.observe(viewLifecycleOwner){
            when(it.first){
                200 -> {
                    it.second.results.forEach { pokemon ->
                        getPokemon(pokemon.name)
                    }
                }
            }
        }
    }

    private fun getPokemon(pokemon: String){
        mutableLiveDataGetPokemon = MutableLiveData<Pair<Int, PokemonResponse>>()
        pokemonViewModel.mutableLiveDataPokemon = mutableLiveDataGetPokemon
        pokemonViewModel.pokemonViewModel(pokemon)
        pokemonViewModel.mutableLiveDataPokemon!!.observe(viewLifecycleOwner){
            if (it != null && it.first != null){
                when(it.first){
                    200 -> {
                        pokemonList.add(it.second)
                        pokemonAdapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }

    override fun clickPokemon(pokemon: PokemonResponse) {
        (activity as MainActivity).toFragment(PokemonFragment(pokemon.name))
    }
}