package com.example.superheroes24.presentation

import androidx.lifecycle.ViewModel
import com.example.superheroes24.domain.models.SuperHero
import com.example.superheroes24.domain.useCases.GetSuperHeroUseCase

class SuperHeroDetailViewModel(
    private val getSuperHeroUseCase: GetSuperHeroUseCase
) : ViewModel() {

    fun viewCreated(superHeroId : String): SuperHero?{
        return getSuperHeroUseCase.invoke(superHeroId)
    }
}