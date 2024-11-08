package com.example.superheroes24.di

import com.example.superheroes24.data.remote.SuperHeroService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.Retrofit


@Module
@ComponentScan("com.example.superheroes24")

class SupereHeroModule {

    @Single
    fun superHeroService(retrofit: Retrofit)=
        retrofit.create(SuperHeroService::class.java)
}