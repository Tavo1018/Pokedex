package com.example.pokedex.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedex.data.PokemonResponse
import com.example.pokedex.data.TypesList
import com.example.pokedex.databinding.ItemPokemonesBinding
import java.sql.Types

class AdapterPokemones(var list: List<PokemonResponse>, context: Context, callback: InterfacePokemon): RecyclerView.Adapter<AdapterPokemones.ViewHolder>(){

    var adapterContext = context
    private lateinit var typesAdapter: AdapterTypes
    private var typeList: ArrayList<TypesList> = arrayListOf()
    private var callback = callback

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val binding = ItemPokemonesBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPokemonesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        render(list[position], list[position].types, holder.binding, adapterContext)
        holder.binding.llPokemon.setOnClickListener {
            callback.clickPokemon(list[position])
        }
    }

    private fun render(pokemon: PokemonResponse, types: List<TypesList>, binding: ItemPokemonesBinding, context: Context) {
        binding.tvPokemon.text = pokemon.name
        Glide.with(context).load(pokemon.sprites.front_default).into(binding.ivPokemon)
        typesAdapter = AdapterTypes(types)
        binding.rvTypes.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.rvTypes.adapter = typesAdapter
    }
}

interface InterfacePokemon {
    fun clickPokemon(pokemon: PokemonResponse)
}