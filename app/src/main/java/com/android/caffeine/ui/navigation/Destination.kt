package com.android.caffeine.ui.navigation

sealed class Destination(val route: String) {
    object HomeScreen : Destination("HomeScreen")
    object DrinkSelectionScreen : Destination("DrinkSelectionScreen")
    object CoffeeDetailsScreen : Destination("CoffeeDetailsScreen/{coffeeId}") {
        fun createRoute(coffeeId: String) = "CoffeeDetailsScreen/$coffeeId"
    }
    object SnackSelectionScreen : Destination("SnackSelectionScreen")
    object SnackDetailsScreen : Destination("SnackDetailsScreen/{snackId}") {
        fun createRoute(snackId: String) = "SnackDetailsScreen/$snackId"
    }
}