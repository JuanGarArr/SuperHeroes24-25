package com.example.superheroes24.data.remote

import com.example.superheroes24.domain.models.Biography
import com.example.superheroes24.domain.models.Images
import com.example.superheroes24.domain.models.PowerStats
import com.example.superheroes24.domain.models.SuperHero
import org.koin.core.annotation.Single

@Single
class SuperHeroMockRemoteDataSource {

    fun getSuperHeroes(): List<SuperHero> {
        val stats1 = PowerStats(100, 85, 90, 80, 100, 95)
        val stats2 = PowerStats(80, 90, 85, 95, 70, 80)
        val stats3 = PowerStats(70, 100, 60, 90, 75, 85)
        val stats4 = PowerStats(90, 70, 85, 75, 80, 90)

        val biography1 = Biography(
            "Kal-El",
            "Clark Kent",
            listOf("Superman", "Man of Steel", "The Last Son of Krypton"),
            "Krypton",
            "Daily Planet",
            "Martha Kent & Jonathan Kent",
            "Lois Lane"
        )
        val biography2 = Biography(
            "Bruce Wayne",
            "Batman",
            listOf("The Dark Knight", "The Caped Crusader", "The World's Greatest Detective"),
            "Gotham City",
            "Wayne Enterprises",
            "Thomas Wayne & Martha Wayne",
            "Selina Kyle (Catwoman)"
        )
        val biography3 = Biography(
            "Diana Prince",
            "Wonder Woman",
            listOf("Wonder Woman", "Princess Diana of Themyscira"),
            "Themyscira",
            "United Nations",
            "Hippolyta",
            "Steve Trevor"
        )
        val biography4 = Biography(
            "Peter Parker",
            "Spider-Man",
            listOf("Spider-Man", "Spidey", "Web-Slinger"),
            "New York City",
            "Daily Bugle",
            "Richard Parker & Mary Parker",
            "Mary Jane Watson"
        )

        val images1 = Images(
            "https://upload.wikimedia.org/wikipedia/en/3/35/Supermanflying.png",
            "https://upload.wikimedia.org/wikipedia/en/3/35/Supermanflying.png",
            "https://upload.wikimedia.org/wikipedia/en/3/35/Supermanflying.png",
            "https://upload.wikimedia.org/wikipedia/en/3/35/Supermanflying.png"
        )

        val images2 = Images(
            "https://upload.wikimedia.org/wikipedia/en/8/87/Batman_DC_Comics.png",
            "https://upload.wikimedia.org/wikipedia/en/8/87/Batman_DC_Comics.png",
            "https://upload.wikimedia.org/wikipedia/en/8/87/Batman_DC_Comics.png",
            "https://upload.wikimedia.org/wikipedia/en/8/87/Batman_DC_Comics.png"
        )

        val images3 = Images(
            "https://upload.wikimedia.org/wikipedia/en/thumb/f/fd/Wonder_Woman_DC_Comics.png/220px-Wonder_Woman_DC_Comics.png",
            "https://upload.wikimedia.org/wikipedia/en/thumb/f/fd/Wonder_Woman_DC_Comics.png/220px-Wonder_Woman_DC_Comics.png",
            "https://upload.wikimedia.org/wikipedia/en/thumb/f/fd/Wonder_Woman_DC_Comics.png/220px-Wonder_Woman_DC_Comics.png",
            "https://upload.wikimedia.org/wikipedia/en/thumb/f/fd/Wonder_Woman_DC_Comics.png/220px-Wonder_Woman_DC_Comics.png"
        )

        val images4 = Images(
            "https://purepng.com/public/uploads/thumbnail//purepng.com-spiderman-comicspider-manspidermansuperherocomic-bookmarvel-comicscharacterstan-leegamesmovie-1701528656362t3kbm.png",
            "https://purepng.com/public/uploads/thumbnail//purepng.com-spiderman-comicspider-manspidermansuperherocomic-bookmarvel-comicscharacterstan-leegamesmovie-1701528656362t3kbm.png",
            "https://purepng.com/public/uploads/thumbnail//purepng.com-spiderman-comicspider-manspidermansuperherocomic-bookmarvel-comicscharacterstan-leegamesmovie-1701528656362t3kbm.png",
            "https://purepng.com/public/uploads/thumbnail//purepng.com-spiderman-comicspider-manspidermansuperherocomic-bookmarvel-comicscharacterstan-leegamesmovie-1701528656362t3kbm.png"
        )

        return listOf(
            SuperHero("1", "Superman", "superman", stats1, biography1, images1),
            SuperHero("2", "Batman", "batman", stats2, biography2, images2),
            SuperHero("3", "Wonder Woman", "wonder_woman", stats3, biography3, images3),
            SuperHero("4", "Spider-Man", "spiderman", stats4, biography4, images4)
        )
    }

    fun getHero(heroId: String): SuperHero?{ //Simular un click sobre item
        return getSuperHeroes().firstOrNull{ hero ->
            hero.id == heroId
        }
    }
}