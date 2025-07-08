package com.example.coffeine.screen.drinkselection

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.android.caffeine.R
import com.android.caffeine.ui.component.ActionButton
import com.android.caffeine.ui.component.TopAppBar
import com.android.caffeine.ui.navigation.Destination
import com.android.caffeine.data.drinksList
import com.example.coffeine.screen.drinkselection.composable.Content
import com.example.coffeine.screen.drinkselection.composable.DrinksSlider

@Composable
fun DrinkSelection(navController: NavController = rememberNavController()) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                TopAppBar(
                    profileImage = painterResource(R.drawable.profile_img),
                    endIcon = painterResource(R.drawable.plus_round),
                )
                Content()
            }
            Spacer(modifier = Modifier.height(56.dp))
            DrinksSlider(
                modifier = Modifier.padding(top = 16.dp),
                drinksList = drinksList,
                onClick = { id ->
                    navController.navigate(Destination.CoffeeDetailsScreen.createRoute(id)) {
                        popUpTo(Destination.CoffeeDetailsScreen.route) { inclusive = true }
                    }
                }
            )
        }
        ActionButton(
            text = "Continue",
            endIcon = painterResource(id = R.drawable.arrow_left_round),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp, start = 99.dp, end = 99.dp),
            onClick = { }
        )
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 1040)
@Composable
private fun DrinkSelectionPreview() {
    DrinkSelection()
}