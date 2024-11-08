package com.example.superheroes24.data.local

import android.content.Context
import com.example.superheroes24.R
import com.example.superheroes24.domain.models.SuperHero
import com.google.gson.Gson
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Single

@Single
class SuperHeroXmlLocalDataSource (private val context: Context){

    val sharedPref = context.getSharedPreferences(
        context.getString(R.string.heroes_file_xml), Context.MODE_PRIVATE
    )

    val gson = Gson()
    val editor = sharedPref.edit()


    fun save (superHero: SuperHero){
        editor.putString(superHero.id, gson.toJson(superHero))
        editor.apply()
    }


    fun saveAll(superHeroes: List<SuperHero>){
        superHeroes.forEach{ hero ->
            editor.putString(hero.id, gson.toJson(hero))
        }
        editor.apply()
    }

    fun getById(id: String): SuperHero?{
        return sharedPref.getString(id, null)?.let {
            gson.fromJson(it, SuperHero::class.java)
        }
    }

    fun getAll(): List<SuperHero>{
        val superHeroes = ArrayList<SuperHero>()
        val mapHeroes = sharedPref.all as Map<String, String>

        mapHeroes.values.forEach {
            val hero = gson.fromJson(it, SuperHero::class.java)
            superHeroes.add(hero)
        }
        return superHeroes
    }

    fun delete(){
        sharedPref.edit().clear().apply()
    }


    fun deleteById(superHeroId: String){
        sharedPref.edit().remove(superHeroId).apply()
    }

}