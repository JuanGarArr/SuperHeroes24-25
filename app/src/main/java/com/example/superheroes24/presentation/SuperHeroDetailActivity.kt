package com.example.superheroes24.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.superheroes24.R
import com.example.superheroes24.domain.models.SuperHero
import com.example.superheroes24.extensions.loadUrl

class SuperHeroDetailActivity : AppCompatActivity() {

    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel:SuperHeroDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero_detail)

        superHeroFactory = SuperHeroFactory(this)
        viewModel = superHeroFactory.buildSuperHeroDetailViewModel()

        getSuperHeroId()?.let { superHeroId ->
            viewModel.viewCreated(superHeroId.toString())?.let { movie ->
                bindData(movie)
            }
        }
    }

    private fun bindData(superHero: SuperHero) {
        val imageView = findViewById<ImageView>(R.id.image1)
        imageView.loadUrl(superHero.id)//por el momento no tengo imagenes ya que lo aplicare al implementar retrofit
    }

    private fun getSuperHeroId(): String? {
       return intent.getStringExtra(KEY_MOVIE_ID)
    }

    companion object{
        val KEY_MOVIE_ID = "key_movie_id"

        fun getIntent(context: Context, superHeroId: String): Intent {
            val intent = Intent(context, SuperHeroDetailActivity::class.java)
            intent.putExtra(KEY_MOVIE_ID, superHeroId)
            return intent
        }
    }

}