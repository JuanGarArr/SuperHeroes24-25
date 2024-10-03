package com.example.superheroes24.domain.models

data class SuperHero(
    val id: String,
    val name: String,
    val slug: String?,
    val powerStats: PowerStats,
    val biography: Biography,
    val images: Images
)

data class PowerStats(
    val inteligence: Int,
    val strength: Int,
    val speed: Int,
    val durability: Int,
    val power: Int,
    val combat: Int
)

data class Biography(
    val fullName: String,
    val alterEgos: String,
    val aliases: List<String>,
    val placeOfBirth: String,
    val firstAppearance: String,
    val publisher: String,
    val alignment: String
)

data class Images(
    val xs: String,
    val sm: String,
    val md: String,
    val lg: String
)