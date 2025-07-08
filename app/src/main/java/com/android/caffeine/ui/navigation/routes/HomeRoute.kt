package com.android.caffeine.ui.navigation.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.android.caffeine.ui.navigation.Destination
import com.android.caffeine.ui.screen.home.Home

fun NavGraphBuilder.HomeRoute(navController: NavController) {
    composable(route = Destination.HomeScreen.route) {
        Home(navController = navController)
    }
}