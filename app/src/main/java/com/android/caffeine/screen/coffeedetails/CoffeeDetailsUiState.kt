package com.android.caffeine.screen.coffeedetails

import com.android.caffeine.R
import com.android.caffeine.model.CoffeeCup

data class CoffeeDetailsUiState(
    val coffeeCup: CoffeeCup = CoffeeCup(
        id = 0,
        type = "",
        img = R.drawable.black,
    ),
)