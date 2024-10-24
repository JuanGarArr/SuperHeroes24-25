package com.example.superheroes24.presentation.apdapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.superheroes24.databinding.ItemSuperheroesBinding
import com.example.superheroes24.databinding.ItemSuperheroesBuenoBinding
import com.example.superheroes24.domain.models.SuperHero

class SuperHeroViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
    val itemSuperHero = ItemSuperheroesBinding.bind(view)

    fun bind(superHero: SuperHero, onClick: (String) -> Unit) {
        itemSuperHero.apply {
            superheroName.text = superHero.name
            superheroAvatar.load(superHero.images.lg)
            superheroFullName.text = superHero.biography.fullName
            view.setOnClickListener {
                onClick(superHero.id)
            }

        }

    }
}