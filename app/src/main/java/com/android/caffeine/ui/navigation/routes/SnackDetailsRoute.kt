package com.android.caffeine.ui.navigation.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.android.caffeine.ui.navigation.Destination
import com.android.caffeine.ui.screen.snackdetails.SnackDetails

fun NavGraphBuilder.SnackDetailsRoute(navController: NavController) {
    composable(route = Destination.SnackDetailsScreen.route) { backStackEntry ->
        val snackId = backStackEntry.arguments?.getString("snackId") ?: return@composable
        SnackDetails(snackId = snackId, navController = navController)
    }
}