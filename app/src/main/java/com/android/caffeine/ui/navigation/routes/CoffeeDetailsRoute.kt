package com.android.caffeine.ui.navigation.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.android.caffeine.ui.navigation.Destination
import com.android.caffeine.ui.screen.coffeedetails.CoffeeDetails

fun NavGraphBuilder.CoffeeDetailsRoute(navController: NavController) {
    composable(route = Destination.CoffeeDetailsScreen.route) { backStackEntry ->
        val coffeeId = backStackEntry.arguments?.getString("coffeeId") ?: return@composable
        CoffeeDetails(cupId = coffeeId, navController = navController)
    }
}