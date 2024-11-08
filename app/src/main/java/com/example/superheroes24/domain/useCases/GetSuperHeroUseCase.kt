package com.example.superheroes24.domain.useCases

import com.example.superheroes24.domain.SuperHeroRepository
import com.example.superheroes24.domain.models.SuperHero
import org.koin.core.annotation.Single

@Single
class GetSuperHeroUseCase(private val superHeroRepository: SuperHeroRepository) {

    suspend operator fun invoke(superHeroId: String): SuperHero?{
        return superHeroRepository.getSuperHero(superHeroId)

    }

}