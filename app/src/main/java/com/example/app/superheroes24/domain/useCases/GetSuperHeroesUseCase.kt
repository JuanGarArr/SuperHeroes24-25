package com.example.app.superheroes24.domain.useCases

import com.example.app.superheroes24.domain.SuperHeroRepository
import com.example.app.superheroes24.domain.models.SuperHero

class GetSuperHeroesUseCase(private val superHeroRepository: SuperHeroRepository) {

    operator fun invoke(): List<SuperHero> {
        return superHeroRepository.getSuperHeroes()

    }

}