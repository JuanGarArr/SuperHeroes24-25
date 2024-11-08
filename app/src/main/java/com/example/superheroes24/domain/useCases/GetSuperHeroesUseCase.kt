package com.example.superheroes24.domain.useCases

import com.example.superheroes24.domain.SuperHeroRepository
import com.example.superheroes24.domain.models.SuperHero
import org.koin.core.annotation.Single

@Single
class GetSuperHeroesUseCase(private val superHeroRepository: SuperHeroRepository) {

    suspend operator fun invoke(): List<SuperHero> {
        return superHeroRepository.getSuperHeroes()

    }

}