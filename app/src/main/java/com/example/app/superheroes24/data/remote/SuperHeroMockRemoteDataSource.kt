package com.example.app.superheroes24.data.remote

import com.example.app.superheroes24.domain.models.Biography
import com.example.app.superheroes24.domain.models.Images
import com.example.app.superheroes24.domain.models.PowerStats
import com.example.app.superheroes24.domain.models.SuperHero

class SuperHeroMockRemoteDataSource {

    fun getSuperHeroes(): List<SuperHero> {
        val stats1 = PowerStats(100, 85, 90, 80, 100, 95) // Fuerza, Velocidad, Resistencia, Inteligencia, Poder, Combate
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
            "https://upload.wikimedia.org/wikipedia/en/3/35/Supermanflying.png",   // Superman.jpg
            "https://upload.wikimedia.org/wikipedia/en/3/35/Supermanflying.png",   // Superman.png
            "https://upload.wikimedia.org/wikipedia/en/3/35/Supermanflying.png",   // Superman_art.png
            "https://upload.wikimedia.org/wikipedia/en/3/35/Supermanflying.png"    // Superman_icon.png
        )

        val images2 = Images(
            "https://upload.wikimedia.org/wikipedia/en/8/87/Batman_DC_Comics.png",  // Batman.jpg
            "https://upload.wikimedia.org/wikipedia/en/8/87/Batman_DC_Comics.png",  // Batman.png
            "https://upload.wikimedia.org/wikipedia/en/8/87/Batman_DC_Comics.png",  // Batman_art.png
            "https://upload.wikimedia.org/wikipedia/en/8/87/Batman_DC_Comics.png"   // Batman_icon.png
        )

        val images3 = Images(
            "https://upload.wikimedia.org/wikipedia/en/e/ed/Wonder_Woman_%282017_film%29.jpg",  // Wonder Woman.jpg
            "https://upload.wikimedia.org/wikipedia/en/e/ed/Wonder_Woman_%282017_film%29.jpg",  // Wonder Woman.png
            "https://upload.wikimedia.org/wikipedia/en/e/ed/Wonder_Woman_%282017_film%29.jpg",  // Wonder Woman_art.png
            "https://upload.wikimedia.org/wikipedia/en/e/ed/Wonder_Woman_%282017_film%29.jpg"   // Wonder Woman_icon.png
        )

        val images4 = Images(
            "https://upload.wikimedia.org/wikipedia/en/0/0c/Spiderman50.jpg",  // Spider-Man.jpg
            "https://upload.wikimedia.org/wikipedia/en/0/0c/Spiderman50.jpg",  // Spider-Man.png
            "https://upload.wikimedia.org/wikipedia/en/0/0c/Spiderman50.jpg",  // Spider-Man_art.png
            "https://upload.wikimedia.org/wikipedia/en/0/0c/Spiderman50.jpg"   // Spider-Man_icon.png
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