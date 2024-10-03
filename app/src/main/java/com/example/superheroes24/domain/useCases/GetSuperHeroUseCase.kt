package com.example.superheroes24.domain.useCases

import com.example.superheroes24.domain.SuperHeroRepository
import com.example.superheroes24.domain.models.SuperHero

class GetSuperHeroUseCase(private val superHeroRepository: SuperHeroRepository) {

    operator fun invoke(superHeroId: String): SuperHero?{
        return superHeroRepository.getSuperHero(superHeroId)

    }

}