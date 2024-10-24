package com.example.superheroes24.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.superheroes24.presentation.SuperHeroDetailFragmentArgs
import com.example.superheroes24.domain.models.SuperHero
import com.example.superheroes24.extensions.loadUrl
import com.example.superheroes24.databinding.FragmentSuperheroDetailBinding

class SuperHeroDetailFragment : Fragment() {

    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroDetailViewModel

    private var _binding: FragmentSuperheroDetailBinding? = null
    private val binding get() = _binding!!

    val args: SuperHeroDetailFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperheroDetailBinding.inflate(inflater, container, false)
    return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        superHeroFactory = SuperHeroFactory(requireContext())
        viewModel = superHeroFactory.buildSuperHeroDetailViewModel()
        setupObservers()
        val superHeroId = args.superHeroId
        viewModel.loadSuperHero(superHeroId)


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
        viewModel.uiState.observe(viewLifecycleOwner, superHeroObserver)
    }

    private fun bindData(superHero: SuperHero) {
        binding.apply {
            superheroImg.loadUrl(superHero.images.md)

            superheroName.text = superHero.name
            superheroFullName.text = superHero.biography.fullName




        }
        }



}