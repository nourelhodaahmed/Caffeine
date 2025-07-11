package com.android.caffeine.ui.screen.coffeedetails

import com.android.caffeine.R
import com.android.caffeine.model.CaffeineSize
import com.android.caffeine.model.CoffeeCup

data class CoffeeDetailsUiState(
    val coffeeCup: CoffeeCup = CoffeeCup(
        id = 0,
        type = "",
        img = R.drawable.black,
        coverImg = R.drawable.black_cover,
        topImg = R.drawable.black_top
    ),
    val selectedCaffeine: CaffeineSize = CaffeineSize.LOW,
    val isBringCoffeeButtonClicked: Boolean = false
)