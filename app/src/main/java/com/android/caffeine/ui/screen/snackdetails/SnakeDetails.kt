package com.android.caffeine.ui.screen.snackdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.caffeine.R
import com.android.caffeine.ui.component.ActionButton
import com.android.caffeine.ui.component.TopAppBar
import com.android.caffeine.ui.screen.snackdetails.component.BonAppetit
import com.android.caffeine.ui.screen.snackdetails.component.CoffeePromoBanner

@Composable
fun SnakeDetails(snakeId : Int) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopAppBar(startIcon = painterResource(R.drawable.cancel_round))

            Spacer(modifier = Modifier.height(24.dp))
            CoffeePromoBanner()

            Spacer(modifier = Modifier.height(24.dp))
            Image(
                painter = painterResource(R.drawable.cupcake),
                contentDescription = "Custom Image",
                modifier = Modifier
                    .size(width = 300.dp, height = 310.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))
            BonAppetit()

        }
        ActionButton(
            text = "Thank youuu",
            endIcon = painterResource(R.drawable.arrow_left_round),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp, start = 99.dp, end = 99.dp),
            onClick = { }
        )
    }
}