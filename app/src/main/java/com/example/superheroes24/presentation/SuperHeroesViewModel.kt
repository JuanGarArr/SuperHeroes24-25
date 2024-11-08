package com.example.superheroes24.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.domain.ErrorApp
import com.example.superheroes24.domain.models.SuperHero
import com.example.superheroes24.domain.useCases.GetSuperHeroUseCase
import com.example.superheroes24.domain.useCases.GetSuperHeroesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SuperHeroesViewModel(
    private val getSuperHeroesUseCase: GetSuperHeroesUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiStage>()
    val uiState: MutableLiveData<UiStage> = _uiState

    fun viewCreated() {

        _uiState.value = UiStage(loading = true)

        viewModelScope.launch (Dispatchers.IO){
            val superHeroes = getSuperHeroesUseCase.invoke()

            delay(1000)

            _uiState.postValue(UiStage(superHeroes = superHeroes))
        }


    }

    data class UiStage(
        val loading: Boolean = false,
        val errorApp : ErrorApp? = null,
        val superHeroes: List<SuperHero>? = null,
    )
}