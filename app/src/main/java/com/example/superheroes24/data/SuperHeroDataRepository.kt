package com.example.superheroes24.data

import com.example.superheroes24.data.local.SuperHeroXmlLocalDataSource
import com.example.superheroes24.data.remote.SuperHeroApiDataSource
import com.example.superheroes24.data.remote.SuperHeroMockRemoteDataSource
import com.example.superheroes24.domain.SuperHeroRepository
import com.example.superheroes24.domain.models.SuperHero
import org.koin.core.annotation.Single

@Single
class SuperHeroDataRepository(
    private val remote: SuperHeroApiDataSource,
    private val local: SuperHeroXmlLocalDataSource
) : SuperHeroRepository {


    override suspend fun getSuperHeroes(): List<SuperHero> {
        val heroesFromLocal = local.getAll()

        return if(heroesFromLocal.isEmpty()){
            val heroesFromRemote = remote.getSuperHeroes()
            local.saveAll(heroesFromRemote)
            heroesFromRemote
        }else{
            heroesFromLocal
        }
    }

    override suspend fun getSuperHero(superHeroId: String): SuperHero? {
        val heroFromLocal = local.getById(superHeroId)

        return if(heroFromLocal == null){
            val superheroFromRemote = remote.getSuperHero(superHeroId)
            superheroFromRemote?.let { superHeroe ->
                local.save(superHeroe)
            }
            superheroFromRemote
        }else{
            heroFromLocal
        }
    }


}