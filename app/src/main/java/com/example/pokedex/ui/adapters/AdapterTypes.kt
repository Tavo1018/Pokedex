package com.example.pokedex.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.data.TypesList
import com.example.pokedex.databinding.ItemTypesBinding
import java.sql.Types

class AdapterTypes(val listTypes: List<TypesList>): RecyclerView.Adapter<AdapterTypes.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val binding = ItemTypesBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTypesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int = listTypes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        render(listTypes[position], holder.binding)
    }

    private fun render(types: TypesList, binding: ItemTypesBinding) {
        binding.tvType.text = types.type.name
    }
}