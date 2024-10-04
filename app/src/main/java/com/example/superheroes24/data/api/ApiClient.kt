package com.example.superheroes24.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://akabab.github.io/superhero-api/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create(ApiService::class.java)

}