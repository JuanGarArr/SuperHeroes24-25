package com.example.superheroes24.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.superheroes24.domain.models.SuperHero

class SuperHeroDiffUtil: DiffUtil.ItemCallback<SuperHero>() {
    override fun areItemsTheSame(oldItem: SuperHero, newItem: SuperHero): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SuperHero, newItem: SuperHero): Boolean {
        return oldItem == newItem
    }

}