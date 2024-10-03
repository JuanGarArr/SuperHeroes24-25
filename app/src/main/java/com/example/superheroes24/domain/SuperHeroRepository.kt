package com.example.superheroes24.domain

import com.example.superheroes24.domain.models.SuperHero

interface SuperHeroRepository {

    fun getSuperHeroes(): List<SuperHero>

    fun getSuperHero(superHeroId: String): SuperHero?
}