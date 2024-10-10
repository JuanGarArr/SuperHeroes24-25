package com.example.app.superheroes24.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.superheroes24.R
import com.example.app.superheroes24.domain.models.SuperHero

class SuperHeroesActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superheroes)

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


