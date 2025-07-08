package com.android.caffeine.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.android.caffeine.ui.navigation.routes.CoffeeDetailsRoute
import com.android.caffeine.ui.navigation.routes.DrinkSelectionRoute
import com.android.caffeine.ui.navigation.routes.HomeRoute
import com.android.caffeine.ui.navigation.routes.SnackDetailsRoute
import com.android.caffeine.ui.navigation.routes.SnackSelectionRoute

@Composable
fun CaffeineNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Destination.HomeScreen.route) {
        HomeRoute(navController)
        DrinkSelectionRoute(navController)
        CoffeeDetailsRoute(navController)
        SnackSelectionRoute(navController)
        SnackDetailsRoute(navController)
    }
}