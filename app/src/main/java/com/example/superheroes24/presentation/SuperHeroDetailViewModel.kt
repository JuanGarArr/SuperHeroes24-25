package com.example.superheroes24.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.domain.ErrorApp
import com.example.superheroes24.domain.models.SuperHero
import com.example.superheroes24.domain.useCases.GetSuperHeroUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SuperHeroDetailViewModel(
    private val getSuperHeroUseCase: GetSuperHeroUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiStage>()
    val uiState: MutableLiveData<UiStage> = _uiState

    fun loadSuperHero(superHeroId : String){
        _uiState.value = UiStage(loading = true)

        viewModelScope.launch (Dispatchers.IO){
            val superHero = getSuperHeroUseCase.invoke(superHeroId)

            delay(1000)

            _uiState.postValue(UiStage(superHero = superHero))

        }

    }

    data class UiStage(
        val loading: Boolean = false,
        val errorApp : ErrorApp? = null,
        val superHero: SuperHero? = null,
    )

}