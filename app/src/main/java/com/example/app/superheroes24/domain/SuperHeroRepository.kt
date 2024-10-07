package com.example.app.superheroes24.domain

import com.example.app.superheroes24.domain.models.SuperHero

interface SuperHeroRepository {

    fun getSuperHeroes(): List<SuperHero>

    fun getSuperHero(superHeroId: String): SuperHero?
}