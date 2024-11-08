package com.example.superheroes24.data.api

data class SuperHeroApiModel (
    val id: String,
    val name: String,
    val urlImage: SuperHeroImageApiModel,
)

data class SuperHeroImageApiModel(
    val md: String,
)