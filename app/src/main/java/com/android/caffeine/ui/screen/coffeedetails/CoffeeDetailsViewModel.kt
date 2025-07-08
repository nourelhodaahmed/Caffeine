package com.android.caffeine.ui.screen.coffeedetails

import androidx.lifecycle.ViewModel
import com.android.caffeine.ui.model.CaffeineSize
import com.android.caffeine.ui.model.CupSize
import com.android.caffeine.ui.screen.utils.drinksList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CoffeeDetailsViewModel() : ViewModel() {
    private val _state = MutableStateFlow<CoffeeDetailsUiState>(CoffeeDetailsUiState())
    val state: StateFlow<CoffeeDetailsUiState> = _state.asStateFlow()

    fun setCoffeeCup(id: Int){
        _state.update { it.copy(coffeeCup = drinksList[id]) }
    }

    fun onChangeCupSize(size: CupSize){
        _state.update { it.copy(coffeeCup = it.coffeeCup.copy(cupSize = size)) }
    }

    fun onChangeCaffeineSize(size: CaffeineSize){
        val newCaffeineSizes = _state.value.coffeeCup.caffeineSize.toMutableList()
        if (newCaffeineSizes.contains(size)) newCaffeineSizes.remove(size)
        else newCaffeineSizes.add(size)
        _state.update { it.copy(
            coffeeCup = it.coffeeCup.copy(caffeineSize = newCaffeineSizes),
            selectedCaffeine = size
        ) }
    }

    fun onBringCoffeeButtonClicked(){
        _state.update { it.copy(isBringCoffeeButtonClicked = true) }
    }
}