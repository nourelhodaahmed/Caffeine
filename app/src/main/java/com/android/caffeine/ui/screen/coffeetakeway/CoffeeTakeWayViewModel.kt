package com.android.caffeine.ui.screen.coffeetakeway

import androidx.lifecycle.ViewModel
import com.android.caffeine.data.drinksList
import com.android.caffeine.ui.screen.coffeedetails.CoffeeDetailsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CoffeeTakeWayViewModel(): ViewModel() {
    private val _state = MutableStateFlow< CoffeeTakeWayUiState>(CoffeeTakeWayUiState())
    val state: StateFlow<CoffeeTakeWayUiState> = _state.asStateFlow()

    fun setCoffeeCup(id: Int){
        _state.update { it.copy(coffeeCup = drinksList[id]) }
    }

}