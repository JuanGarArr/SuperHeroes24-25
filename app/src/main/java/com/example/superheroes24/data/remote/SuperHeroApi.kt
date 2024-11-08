package com.example.superheroes24.data.remote

import com.google.gson.annotations.SerializedName

data class SuperHeroApiModel (
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val urlImage: String,
)

