package com.example.app.superheroes24.data.remote

import com.example.app.superheroes24.data.api.SuperHeroService
import com.example.app.superheroes24.domain.models.SuperHero

class SuperHeroApiDataSource (private val superHeroService: SuperHeroService){


    suspend fun getSuperHeroes(): List<SuperHero> {
        val response = superHeroService.requestSuperHeroes()

         return if(response.isSuccessful){
             response.body()!!
         }else
             emptyList()

    }

        suspend fun getSuperHero(superHeroId: String): SuperHero? {
        val response = superHeroService.requestSuperHero(superHeroId)

            return if(response.isSuccessful){
                response.body()!!

            }else{
                null

            }

    }
}