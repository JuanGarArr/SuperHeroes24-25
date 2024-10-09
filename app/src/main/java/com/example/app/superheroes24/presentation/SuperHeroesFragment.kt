package com.example.app.superheroes24.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.superheroes24.databinding.FragmentSuperheroesBinding

class SuperHeroesFragment : Fragment(){

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


}

