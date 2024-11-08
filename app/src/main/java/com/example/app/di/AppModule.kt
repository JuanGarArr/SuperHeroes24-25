package com.example.app.di

import com.example.superheroes24.data.remote.SuperHeroService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.Retrofit


@Module
@ComponentScan("com.example")
class AppModule {
    @Single
    fun provideSuperHeroService(retrofit: Retrofit): SuperHeroService =
        retrofit.create(SuperHeroService::class.java)

}