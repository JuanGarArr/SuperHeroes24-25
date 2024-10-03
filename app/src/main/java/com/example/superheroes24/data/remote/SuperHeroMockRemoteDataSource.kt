package com.example.superheroes24.data.remote

import com.example.superheroes24.domain.models.Biography
import com.example.superheroes24.domain.models.Images
import com.example.superheroes24.domain.models.PowerStats
import com.example.superheroes24.domain.models.SuperHero

class SuperHeroMockRemoteDataSource {

    fun getSuperHeroes(): List<SuperHero>{
        val stats1 = PowerStats(1,2,3,4,5,6)
        val stats2 =PowerStats(1,2,3,4,5,6)
        val stats3 =PowerStats(1,2,3,4,5,6)

        val biography1 = Biography("1","2", listOf("alias1","alias2","alias3"),"4","5","6","7")
        val biography2 = Biography("1","2", listOf("alias1","alias2","alias3"),"4","5","6","7")
        val biography3 = Biography("1","2", listOf("alias1","alias2","alias3"),"4","5","6","7")

        val images1 = Images("1","2","3","4")
        val images2 =Images("1","2","3","4")
        val images3 =Images("1","2","3","4")

        return listOf(

            SuperHero("1","name1", "slug1", stats1, biography1, images1),
            SuperHero("2","name2", "slug2", stats2, biography2, images2),
            SuperHero("3","name3", "slug3", stats3, biography3, images3),
        )
    }

    fun getHero(heroId: String): SuperHero?{ //Simular un click sobre item
        return getSuperHeroes().firstOrNull{ hero ->
            hero.id == heroId
        }
    }
}