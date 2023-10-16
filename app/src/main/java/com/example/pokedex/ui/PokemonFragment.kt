package com.example.pokedex.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.viewpager2.widget.ViewPager2
import com.example.pokedex.R
import com.example.pokedex.data.PokemonResponse
import com.example.pokedex.databinding.FragmentPokemonBinding
import com.example.pokedex.databinding.FragmentPokemonesBinding
import com.example.pokedex.ui.adapters.InfoPagerAdapter
import com.example.pokedex.viewModel.PokemonViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.tabs.TabLayout

class PokemonFragment(pokemon: String) : Fragment(R.layout.fragment_pokemon) {

    var pokemonName = pokemon
    private var _binding: FragmentPokemonBinding? = null
    private val binding get() = _binding!!
    private val pokemonViewModel: PokemonViewModel by viewModels()
    private var mutableLiveDataGetPokemon: MutableLiveData<Pair<Int,PokemonResponse>>? = null
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var infoAdapter: InfoPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPokemon(pokemonName)

        tabLayout = binding.tabMode
        viewPager2 = binding.viewPager2

        tabLayout.addTab(tabLayout.newTab().setText("About"))
        tabLayout.addTab(tabLayout.newTab().setText("Base Stats"))
        tabLayout.addTab(tabLayout.newTab().setText("Evolution"))
        tabLayout.addTab(tabLayout.newTab().setText("Moves"))

        infoAdapter = InfoPagerAdapter(childFragmentManager, lifecycle)
        viewPager2.adapter = infoAdapter

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager2.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })

        BottomSheetBehavior.from(binding.flSheet).apply {
            peekHeight = 200
            this.state = BottomSheetBehavior.STATE_COLLAPSED
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
                        binding.tvPokemonName.text = it.second.name
                        binding.tvPokemonNumber.text = it.second.id.toString()

                        //infoAdapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }
}