package com.example.superheroes24.data

import com.example.superheroes24.data.local.SuperHeroXmlLocalDataSource
import com.example.superheroes24.data.remote.SuperHeroRetrofitDataSource
import com.example.superheroes24.domain.SuperHeroRepository
import com.example.superheroes24.domain.models.SuperHero

class SuperHeroDataRepository(
    private val remote:SuperHeroRetrofitDataSource,
    private val local:SuperHeroXmlLocalDataSource
) : SuperHeroRepository {



    override fun getSuperHeroes(): List<SuperHero> {
        val heroesFromLocal = local.getAll()

        return if(heroesFromLocal.isEmpty()){
            val heroesFromRemote = remote.getSuperHeroes()
            local.saveAll(heroesFromRemote)
            heroesFromRemote
        }else{
            heroesFromLocal
        }
    }

    override fun getSuperHero(superHeroId: String): SuperHero? {
        val heroFromLocal = local.getById(superHeroId)

        return if(heroFromLocal == null){
            val superheroFromRemote = remote.getHero(superHeroId)
            superheroFromRemote?.let { superHeroe ->
                local.save(superHeroe)
            }
            superheroFromRemote
        }else{
            heroFromLocal
        }
    }


}