package com.example.superheroes24.presentation

import androidx.lifecycle.ViewModel
import com.example.superheroes24.domain.models.SuperHero
import com.example.superheroes24.domain.useCases.GetSuperHeroUseCase
import com.example.superheroes24.domain.useCases.GetSuperHeroesUseCase

class SuperHeroesViewModel(
    private val getSuperHeroUseCase: GetSuperHeroUseCase,
    private val getSuperHeroesUseCase: GetSuperHeroesUseCase
) : ViewModel() {

    fun viewCreated() : List<SuperHero>{
        return getSuperHeroesUseCase.invoke()
    }

    fun itemSelected(superHeroId: String): SuperHero? {
        return getSuperHeroUseCase.invoke(superHeroId)
    }
}