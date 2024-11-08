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
import com.example.superheroes24.databinding.FragmentSuperheroesBinding
import com.example.superheroes24.presentation.apdapter.SuperHeroAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class SuperHeroesFragment : Fragment() {

    private val viewModel: SuperHeroesViewModel by viewModel()

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
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

    private fun setupView() {
        binding.apply {
            heroesRecyclerView.apply {
                layoutManager = GridLayoutManager(
                    context,
                    2,
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
        findNavController().navigate(
            SuperHeroesFragmentDirections.superheroesFragmentToSuperheroFragmentDetail(
                heroId
            )
        )

    }




}
