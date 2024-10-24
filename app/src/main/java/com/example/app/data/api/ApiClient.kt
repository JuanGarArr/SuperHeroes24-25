package com.example.app.data.api

import com.example.superheroes24.data.api.SuperHeroService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

        private const val BASE_URL_API = "https://akabab.github.io/superhero-api/api/"

        private fun provideRetrofit(): Retrofit{
                return Retrofit.Builder()
                        .baseUrl(BASE_URL_API)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()


        }

        fun provideSuperHeroService(): SuperHeroService {
                return provideRetrofit().create(SuperHeroService::class.java)

        }


}