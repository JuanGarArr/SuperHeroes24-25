package com.example.superheroes24.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.superheroes24.R
import com.example.superheroes24.domain.models.SuperHero

class SuperHeroesActivity : AppCompatActivity() {

    private lateinit var superHeroFactory : SuperHeroFactory
    private lateinit var viewModel: SuperHeroesViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superheroes)

        superHeroFactory = SuperHeroFactory(this)
        viewModel = superHeroFactory.buildViewModel()

        val superHeroes = viewModel.viewCreated()

        bindData(superHeroes)

        }


    private fun bindData(superHeroes: List<SuperHero>) {

        findViewById<TextView>(R.id.hero_id_1)
        findViewById<TextView>(R.id.hero_name_1)
        findViewById<LinearLayout>(R.id.layout1).setOnClickListener {
            navigateToSuperHeroDetail(superHeroes[0])
        }

        findViewById<TextView>(R.id.hero_id_2)
        findViewById<TextView>(R.id.hero_name_2)
        findViewById<LinearLayout>(R.id.layout2).setOnClickListener {
            navigateToSuperHeroDetail(superHeroes[1])
        }

        findViewById<TextView>(R.id.hero_id_3)
        findViewById<TextView>(R.id.hero_name_3)
        findViewById<LinearLayout>(R.id.layout3).setOnClickListener {
            navigateToSuperHeroDetail(superHeroes[2])
        }

        findViewById<TextView>(R.id.hero_id_4)
        findViewById<TextView>(R.id.hero_name_4)
        findViewById<LinearLayout>(R.id.layout4).setOnClickListener {
            navigateToSuperHeroDetail(superHeroes[3])
        }

    }

    private fun navigateToSuperHeroDetail(superHero: SuperHero) {
        startActivity(SuperHeroDetailActivity.getIntent(this, superHero.id))
    }

    override fun onStart() {
        super.onStart()
        Log.d("SuperHeroesActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SuperHeroesActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SuperHeroesActivity", "onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.d("SuperHeroesActivity", "onStop")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d("SuperHeroesActivity", "onDestroy")
    }






}

