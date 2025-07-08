package com.android.caffeine.ui.screen.snackdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.android.caffeine.R
import com.android.caffeine.data.snacks
import com.android.caffeine.ui.component.ActionButton
import com.android.caffeine.ui.component.TopAppBar
import com.android.caffeine.ui.navigation.Destination
import com.android.caffeine.ui.screen.snackdetails.component.BonAppetit
import com.android.caffeine.ui.screen.snackdetails.component.CoffeePromoBanner

@Composable
fun SnackDetails(
    snackId : String,
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopAppBar(
                modifier = Modifier.padding(bottom = 24.dp),
                startIcon = painterResource(R.drawable.cancel_round),
                onStartIconClicked = {
                    navController.navigate(Destination.SnackSelectionScreen.route) {
                        popUpTo(Destination.SnackDetailsScreen.route) { inclusive = true }
                    }
                }
            )
            CoffeePromoBanner()
            Image(
                painter = painterResource(snacks[snackId.toInt()].img),
                contentDescription = "Custom Image",
                modifier = Modifier
                    .padding(top = 24.dp, bottom = 12.dp)
                    .size(width = 300.dp, height = 310.dp)
            )
            BonAppetit()
        }
        ActionButton(
            text = "Thank youuu",
            endIcon = painterResource(R.drawable.arrow_right_round),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp),
            onClick = {
                navController.navigate(Destination.HomeScreen.route) {
                    popUpTo(Destination.SnackDetailsScreen.route) { inclusive = true }
                }
            }
        )
    }
}