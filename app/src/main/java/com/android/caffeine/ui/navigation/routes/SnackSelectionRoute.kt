package com.android.caffeine.ui.navigation.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.android.caffeine.ui.navigation.Destination
import com.android.caffeine.ui.screen.snackselection.SnackSelection

fun NavGraphBuilder.SnackSelectionRoute(navController: NavController) {
    composable(route = Destination.SnackSelectionScreen.route) {
        SnackSelection(navController = navController)
    }
}