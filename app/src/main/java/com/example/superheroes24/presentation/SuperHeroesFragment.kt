package com.example.superheroes24.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.extensions.loadUrl
import com.example.superheroes24.presentation.SuperHeroesFragmentDirections
import com.example.superheroes24.domain.models.SuperHero
import com.example.superheroes24.R
import com.example.superheroes24.databinding.FragmentSuperheroesBinding
import com.example.superheroes24.presentation.apdapter.SuperHeroAdapter


class SuperHeroesFragment : Fragment() {

    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroesViewModel

    private var _binding: FragmentSuperheroesBinding? = null
    private val binding get() = _binding!!

    val superHeroAdapter: SuperHeroAdapter = SuperHeroAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperheroesBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    private fun setupView() {
        binding.apply {
            heroesRecyclerView.apply {
                layoutManager = GridLayoutManager(
                    context,
                    1,
                    LinearLayoutManager.VERTICAL,
                    false

                )
                superHeroAdapter.setEvent { heroId ->
                    navigateToDetail(heroId)

                }
                adapter = superHeroAdapter

            }
        }
    }

    private fun navigateToDetail(heroId: String) {
        findNavController().navigate(SuperHeroesFragmentDirections.superheroesFragmentToSuperheroFragmentDetail(heroId))

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
            superHeroAdapter.submitList(superHeroes)
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

}
