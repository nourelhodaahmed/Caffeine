package com.android.caffeine.Screen.coffeedetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.caffeine.R
import com.android.caffeine.composable.TopAppBar

@Composable
fun CoffeeDetails(){
    Column (
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
    ){
        TopAppBar(
            modifier = Modifier.padding(bottom = 16.dp),
            startIcon = painterResource(R.drawable.arrow_left_round),
            title = "Macchiato"
        )
    }
}

@Preview
@Composable
private fun CoffeeDetailsPreview(){
    CoffeeDetails()
}
