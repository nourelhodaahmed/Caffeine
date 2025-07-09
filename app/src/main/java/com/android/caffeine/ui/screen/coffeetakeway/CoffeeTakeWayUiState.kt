package com.android.caffeine.ui.screen.coffeetakeway

import com.android.caffeine.R
import com.android.caffeine.model.CoffeeCup

data class CoffeeTakeWayUiState(
    val coffeeCup: CoffeeCup = CoffeeCup(
        id = 0,
        type = "",
        img = R.drawable.black,
        coverImg = R.drawable.black_cover,
        topImg = R.drawable.black_top
    ),
)