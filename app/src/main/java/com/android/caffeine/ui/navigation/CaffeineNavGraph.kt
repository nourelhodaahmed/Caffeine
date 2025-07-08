package com.android.caffeine.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.android.caffeine.ui.navigation.routes.CoffeeDetailsRoute
import com.android.caffeine.ui.navigation.routes.DrinkSelectionRoute
import com.android.caffeine.ui.navigation.routes.HomeRoute

@Composable
fun CaffeineNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Destination.HomeScreen.route) {
        DrinkSelectionRoute(navController)
        HomeRoute(navController)
        CoffeeDetailsRoute(navController)
    }
}