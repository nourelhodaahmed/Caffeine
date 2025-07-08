package com.android.caffeine.ui.screen.coffeedetails

import com.android.caffeine.R
import com.android.caffeine.ui.model.CaffeineSize
import com.android.caffeine.ui.model.CoffeeCup

data class CoffeeDetailsUiState(
    val coffeeCup: CoffeeCup = CoffeeCup(
        id = 0,
        type = "",
        img = R.drawable.black,
    ),
    val selectedCaffeine: CaffeineSize = CaffeineSize.LOW,
    val isBringCoffeeButtonClicked: Boolean = false
)