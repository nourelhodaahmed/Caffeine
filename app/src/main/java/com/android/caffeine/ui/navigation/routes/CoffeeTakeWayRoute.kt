package com.android.caffeine.ui.navigation.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.android.caffeine.ui.navigation.Destination
import com.android.caffeine.ui.screen.coffeetakeway.CoffeeTakeWay

fun NavGraphBuilder.CoffeeTakeWayRoute(navController: NavController) {
    composable(route = Destination.CoffeeTakeWayScreen.route) { backStackEntry ->
        val coffeeId = backStackEntry.arguments?.getString("coffeeId") ?: return@composable
        CoffeeTakeWay(cupId = coffeeId, navController = navController)
    }
}