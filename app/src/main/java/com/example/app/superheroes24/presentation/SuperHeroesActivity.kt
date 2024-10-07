package com.example.app.superheroes24.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.superheroes24.R
import com.example.app.superheroes24.domain.models.SuperHero

class SuperHeroesActivity : AppCompatActivity() {

    private lateinit var superHeroFactory : SuperHeroFactory
    private lateinit var viewModel: SuperHeroesViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superheroes)

        superHeroFactory = SuperHeroFactory(this)
        viewModel = superHeroFactory.buildViewModel()

        setupObservers()
        viewModel.viewCreated(this)

        }

    private fun setupObservers() {
        val superHeroesObserver = Observer<SuperHeroesViewModel.UiStage> { uiState ->
            uiState.superHeroes?.let { superHeroes ->
                bindData(superHeroes)
            }

            uiState.errorApp?.let { errorApp ->
                Log.d("SuperHeroesActivity", "errorApp")
            }

            uiState.loading?.let { loading ->
                Log.d("SuperHeroesActivity", "loading")
            }
        }
        viewModel.uiState.observe(this, superHeroesObserver)
    }


    private fun bindData(superHeroes: List<SuperHero>) {

        findViewById<TextView>(R.id.hero_id_1).text = superHeroes[0].id
        findViewById<TextView>(R.id.hero_name_1).text = superHeroes[0].name
        findViewById<LinearLayout>(R.id.layout1).setOnClickListener {
            navigateToSuperHeroDetail(superHeroes[0].id)
        }

        findViewById<TextView>(R.id.hero_id_2).text = superHeroes[1].id
        findViewById<TextView>(R.id.hero_name_2).text = superHeroes[1].name
        findViewById<LinearLayout>(R.id.layout2).setOnClickListener {
            navigateToSuperHeroDetail(superHeroes[1].id)
        }

        findViewById<TextView>(R.id.hero_id_3).text = superHeroes[2].id
        findViewById<TextView>(R.id.hero_name_3).text = superHeroes[2].name
        findViewById<LinearLayout>(R.id.layout3).setOnClickListener {
            navigateToSuperHeroDetail(superHeroes[2].id)
        }

        findViewById<TextView>(R.id.hero_id_4).text = superHeroes[3].id
        findViewById<TextView>(R.id.hero_name_4).text = superHeroes[3].name
        findViewById<LinearLayout>(R.id.layout4).setOnClickListener {
            navigateToSuperHeroDetail(superHeroes[3].id)
        }

    }

    private fun navigateToSuperHeroDetail(superHeroId: String) {
        startActivity(SuperHeroDetailActivity.getIntent(this, superHeroId))
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

