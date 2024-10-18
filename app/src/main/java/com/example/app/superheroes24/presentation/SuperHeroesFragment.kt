package com.example.app.superheroes24.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.app.extensions.loadUrl
import com.example.app.superheroes24.domain.models.SuperHero
import com.example.superheroes24.R
import com.example.superheroes24.databinding.FragmentSuperheroesBinding

class SuperHeroesFragment : Fragment(){

    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroesViewModel

    private var _binding: FragmentSuperheroesBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperheroesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        superHeroFactory = SuperHeroFactory(requireContext())
        viewModel = superHeroFactory.buildViewModel()
        setupObservers()
        viewModel.viewCreated()
    }

    private fun setupObservers() {
        val superHeroesObserver = Observer<SuperHeroesViewModel.UiStage> { uiState ->
            uiState.superHeroes?.let { superHeroes ->
                bindData(superHeroes)
            }

            uiState.errorApp?.let { errorApp ->
                Log.d("@dev", "errorApp")
            }

            if (uiState.loading) {
                Log.d("@dev", "isLoading")
            } else {
                Log.d("@dev", "Loaded")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, superHeroesObserver)
    }

    private fun bindData(superHeroes: List<SuperHero>) {
        binding.apply{
            superheroAvatar1.loadUrl(superHeroes[0].images.lg)
            superheroName1.text = superHeroes[0].name
            superheroDescription1.text = superHeroes[0].biography.fullName
            layout1.setOnClickListener {
                findNavController().navigate(SuperHeroesFragmentDirections.superheroesFragmentToSuperheroFragmentDetail(superHeroes[0].id))
            }

            superheroAvatar2.loadUrl(superHeroes[1].images.lg)
            superheroName2.text = superHeroes[1].name
            superheroDescription2.text = superHeroes[1].biography.fullName
            layout2.setOnClickListener {
                findNavController().navigate(SuperHeroesFragmentDirections.superheroesFragmentToSuperheroFragmentDetail(superHeroes[1].id))
            }

            superheroAvatar3.loadUrl(superHeroes[2].images.lg)
            superheroName3.text = superHeroes[2].name
            superheroDescription3.text = superHeroes[2].biography.fullName
            layout3.setOnClickListener {
                findNavController().navigate(SuperHeroesFragmentDirections.superheroesFragmentToSuperheroFragmentDetail(superHeroes[2].id))
            }

            superheroAvatar4.loadUrl(superHeroes[3].images.lg)
            superheroName4.text = superHeroes[3].name
            superheroDescription4.text = superHeroes[3].biography.fullName
            layout4.setOnClickListener {
                findNavController().navigate(SuperHeroesFragmentDirections.superheroesFragmentToSuperheroFragmentDetail(superHeroes[3].id))
            }
        }
    }


}

