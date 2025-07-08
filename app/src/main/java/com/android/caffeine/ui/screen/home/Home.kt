package com.android.caffeine.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.android.caffeine.R
import com.android.caffeine.ui.component.ActionButton
import com.android.caffeine.ui.screen.home.component.CoffeeGhost
import com.android.caffeine.ui.screen.home.component.Content
import com.android.caffeine.ui.component.TopAppBar
import com.android.caffeine.ui.navigation.Destination

@Composable
fun Home(navController: NavController = rememberNavController()) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ){
        TopAppBar(profileImage = painterResource(R.drawable.profile_img), endIcon = painterResource(R.drawable.plus_round))
        Content(modifier = Modifier.padding(top = 24.dp))
        CoffeeGhost()
        ActionButton(
            modifier = Modifier
            .padding(top = 58.91.dp)
            .align(Alignment.CenterHorizontally),
            text = "bring my coffee",
            endIcon = painterResource(R.drawable.coffee),
            onClick = {
                navController.navigate(Destination.DrinkSelectionScreen.route) {
                    popUpTo(Destination.HomeScreen.route) { inclusive = true }
                }
            }
        )
    }
}

@Preview
@Composable
private fun HomePreview() {
    Home()
}