package com.android.caffeine.data

import com.android.caffeine.R
import com.android.caffeine.model.CoffeeCup

val drinksList = listOf(
    CoffeeCup(
        id = 0,
        img = R.drawable.black,
        coverImg = R.drawable.black_cover,
        topImg = R.drawable.black_top,
        type = "Black"
    ),
    CoffeeCup(
        id = 1,
        img = R.drawable.latte,
        coverImg = R.drawable.latte_cover,
        topImg = R.drawable.latte_top,
        type = "Latte"
    ),
    CoffeeCup(
        id = 2,
        img = R.drawable.macchiato,
        coverImg = R.drawable.macchiato_cover,
        topImg = R.drawable.macchiato_top,
        type = "Macchiato"
    ),
    CoffeeCup(
        id = 3,
        img = R.drawable.espresso,
        coverImg = R.drawable.espresso_cover,
        topImg = R.drawable.espresso_top,
        type = "Espresso"
    )
)