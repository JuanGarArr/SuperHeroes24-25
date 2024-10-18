package com.example.app.superheroes24.data.api

import com.example.app.superheroes24.domain.models.SuperHero
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperHeroService {

    //rest api: post, get, put, delete, patch

    @GET("all.json")
    suspend fun requestSuperHeroes(): Response<List<SuperHero>>

    @GET("id/{id}.json")
    suspend fun requestSuperHero(@Path("id") superHeroId: String): Response<SuperHero>

}