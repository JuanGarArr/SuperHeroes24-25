package com.example.superheroes24.domain

import com.example.superheroes24.domain.models.SuperHero

interface SuperHeroRepository {

    suspend fun getSuperHeroes(): List<SuperHero>

    suspend fun getSuperHero(superHeroId: String): SuperHero?
}