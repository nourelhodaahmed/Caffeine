package com.android.caffeine.screen.coffeedetails

import androidx.lifecycle.ViewModel
import com.android.caffeine.model.CaffeineSize
import com.android.caffeine.model.CupSize
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CoffeeDetailsViewModel() : ViewModel() {
    private val _state = MutableStateFlow<CoffeeDetailsUiState>(CoffeeDetailsUiState())
    val state: StateFlow<CoffeeDetailsUiState> = _state.asStateFlow()

    fun onChangeCupSize(size: CupSize){
        _state.update { it.copy(coffeeCup = it.coffeeCup.copy(cupSize = size)) }
    }

    fun onChangeCaffeineSize(size: CaffeineSize){
        val newCaffeineSizes = _state.value.coffeeCup.caffeineSize.toMutableList()
        if (newCaffeineSizes.contains(size)) newCaffeineSizes.remove(size)
        else newCaffeineSizes.add(size)
        _state.update { it.copy(coffeeCup = it.coffeeCup.copy(caffeineSize = newCaffeineSizes)) }
    }
}