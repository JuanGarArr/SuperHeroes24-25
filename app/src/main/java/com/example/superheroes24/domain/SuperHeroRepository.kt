package com.example.superheroes24.domain

import com.example.superheroes24.domain.models.SuperHero
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Single


interface SuperHeroRepository {

    suspend fun getSuperHeroes(): List<SuperHero>

    suspend fun getSuperHero(superHeroId: String): SuperHero?
}