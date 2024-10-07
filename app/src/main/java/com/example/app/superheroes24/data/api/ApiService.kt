package com.example.app.superheroes24.data.api

import com.example.app.superheroes24.domain.models.SuperHero
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("all.json")

    fun getSuperHeroes(): Response<List<SuperHero>>

}