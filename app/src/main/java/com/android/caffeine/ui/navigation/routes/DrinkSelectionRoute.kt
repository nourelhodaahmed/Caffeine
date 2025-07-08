package com.android.caffeine.ui.navigation.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.android.caffeine.ui.navigation.Destination
import com.example.coffeine.screen.drinkselection.DrinkSelection

fun NavGraphBuilder.DrinkSelectionRoute(navController: NavController) {
    composable(route = Destination.DrinkSelectionScreen.route) {
        DrinkSelection(navController = navController)
    }
}