package com.example.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.pokedex.ui.PokemonFragment
import com.example.pokedex.ui.PokemonesFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toFragmentNonReturn(PokemonFragment("Hola"))
    }

    fun toFragment(fragmento: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.ll_container, fragmento).addToBackStack(null).commit()
    }

    fun replaceFragment(fragmento: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.ll_container, fragmento).commit()
    }

    fun addFragment(fragmento: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().add(R.id.ll_container, fragmento).commit()
    }

    fun toFragmentNonReturn(fragmento: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.ll_container, fragmento)
            .commit()

    }
}