package com.example.superheroes24.presentation.apdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.superheroes24.R
import com.example.superheroes24.domain.models.SuperHero
import com.example.superheroes24.presentation.SuperHeroDiffUtil

class SuperHeroAdapter: ListAdapter<SuperHero, SuperHeroViewHolder>(SuperHeroDiffUtil()) {

    lateinit var onClick: (superheroId: String) -> Unit

    fun setEvent(onClick: (superheroId: String) -> Unit) {
        this.onClick = onClick
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_superheroes, parent, false)
        return SuperHeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.bind(currentList[position], onClick)
    }

}