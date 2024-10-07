package com.example.app.superheroes24.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.superheroes24.R
import com.example.app.superheroes24.domain.models.SuperHero
import com.example.app.superheroes24.extensions.loadUrl

class SuperHeroDetailActivity : AppCompatActivity() {

    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero_detail)

        superHeroFactory = SuperHeroFactory(this)
        viewModel = superHeroFactory.buildSuperHeroDetailViewModel()

        setupObservers()
        viewModel.viewCreated(getSuperHeroId()!!)
    }

    private fun setupObservers() {
        val superHeroObserver = Observer<SuperHeroDetailViewModel.UiStage> { uiState ->
            uiState.superHero?.let { superHero ->
                bindData(superHero)
            }
            uiState.errorApp?.let { errorApp ->
                Log.d("@dev", "errorApp")
            }

            if (uiState.loading){
                Log.d("@dev", "isLoading")
            }else{
                Log.d("@dev", "Loaded")
            }
        }
        viewModel.uiState.observe(this, superHeroObserver)
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