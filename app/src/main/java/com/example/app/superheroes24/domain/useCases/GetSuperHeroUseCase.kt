package com.example.app.superheroes24.domain.useCases

import com.example.app.superheroes24.domain.SuperHeroRepository
import com.example.app.superheroes24.domain.models.SuperHero

class GetSuperHeroUseCase(private val superHeroRepository: SuperHeroRepository) {

    operator fun invoke(superHeroId: String): SuperHero?{
        return superHeroRepository.getSuperHero(superHeroId)

    }

}