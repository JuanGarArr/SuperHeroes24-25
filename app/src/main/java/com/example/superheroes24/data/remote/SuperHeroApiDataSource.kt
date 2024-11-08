package com.example.superheroes24.data.remote

import com.example.app.di.AppModule
import com.example.app.di.RemoteModule
import com.example.superheroes24.domain.models.SuperHero
import org.koin.core.annotation.Single

@Single
class SuperHeroApiDataSource {

    private val superHeroModule = AppModule()
    private val remoteModule = RemoteModule()

    suspend fun getSuperHeroes(): List<SuperHero> {
        val loginInterceptor = remoteModule.provideLogginInterceptor()
        val okHttpClient = remoteModule.provideOkHttpClient(loginInterceptor)
        val retrofit = remoteModule.provideRetrofit(okHttpClient)

        val superHeroes = superHeroModule.provideSuperHeroService(retrofit).requestSuperHeroes()
        if(superHeroes.body()?.isNotEmpty()!!){
            return superHeroes.body()!!.map {
                it.toModel()
            }

            }

    }

    suspend fun getSuperHero(superHeroId: String): SuperHero? {
        val response = superHeroModule.provideSuperHeroService(retrofit).requestSuperHero(superHeroId)
        return if(response.isSuccessful){
            response.body()!!

        }else{
            null
        }

    }
}