package com.android.caffeine.model

import androidx.compose.ui.graphics.painter.Painter

data class CoffeeCup(
    val id: Int,
    val type: String,
    val img: Int,
    val cupSize: CupSize = CupSize.S,
    val caffeineSize: List<CaffeineSize> = listOf(),
)