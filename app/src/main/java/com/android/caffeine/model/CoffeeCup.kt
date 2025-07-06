package com.android.caffeine.model

data class CoffeeCup(
    val id: Int,
    val type: String,
    val img: Int,
    val cupSize: CupSize = CupSize.S,
    val caffeineSize: List<CaffeineSize> = listOf(),
)