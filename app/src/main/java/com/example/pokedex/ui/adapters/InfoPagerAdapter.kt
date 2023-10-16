package com.example.pokedex.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pokedex.ui.AboutFragment
import com.example.pokedex.ui.BaseStatsFragment
import com.example.pokedex.ui.EvolutionsFragment
import com.example.pokedex.ui.MovesFragment

class InfoPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {

        return when(position){
            0 -> AboutFragment()
            1 -> BaseStatsFragment()
            2 -> EvolutionsFragment()
            else -> {
                MovesFragment()
            }
        }
    }
}