package com.android.caffeine.ui.screen.coffeetakeway.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.caffeine.ui.theme.HomeContent
import com.android.caffeine.ui.theme.Urbanist

@Composable
fun CoffeeReady(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        ReadyButton()
        Text(
            text = "Your coffee is ready,\n" +
                    "Enjoy",
            style = TextStyle(
                fontFamily = Urbanist,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                letterSpacing = 0.25.sp,
            ),
            color = HomeContent
        )
    }
}

@Preview
@Composable
private fun CoffeeReadyPreview(){
    CoffeeReady()
}