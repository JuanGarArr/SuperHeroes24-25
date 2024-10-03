package com.example.superheroes24.presentation

import android.content.Context
import com.example.superheroes24.data.SuperHeroDataRepository
import com.example.superheroes24.data.local.SuperHeroXmlLocalDataSource
import com.example.superheroes24.data.remote.SuperHeroMockRemoteDataSource
import com.example.superheroes24.domain.useCases.GetSuperHeroUseCase
import com.example.superheroes24.domain.useCases.GetSuperHeroesUseCase

class SuperHeroFactory (private val context: Context) {

    val superHeroMockRemote = SuperHeroMockRemoteDataSource()
    val superHeroXmlLocal = SuperHeroXmlLocalDataSource(context)

    val superHeroDataRepository = SuperHeroDataRepository(superHeroMockRemote, superHeroXmlLocal)

    val getSuperHeroUseCase = GetSuperHeroUseCase(superHeroDataRepository)
    val getSuperHeroesUseCase = GetSuperHeroesUseCase(superHeroDataRepository)

    fun buildViewModel(): SuperHeroesViewModel {
        return SuperHeroesViewModel(getSuperHeroUseCase,getSuperHeroesUseCase)

    }

    fun buildSuperHeroDetailViewModel(): SuperHeroDetailViewModel {
        return SuperHeroDetailViewModel(getSuperHeroUseCase)

    }

}