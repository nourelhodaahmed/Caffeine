package com.android.caffeine.screen.coffeedetails.composable

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.caffeine.R
import com.android.caffeine.model.CoffeeCup
import com.android.caffeine.model.CupSize
import com.android.caffeine.ui.theme.HomeContent
import com.android.caffeine.ui.theme.Urbanist

@Composable
fun CoffeeCupDetails(
    coffeeCup: CoffeeCup,
    modifier: Modifier = Modifier
) {
    val cupWidth by animateDpAsState(
        targetValue = when(coffeeCup.cupSize){
            CupSize.S -> 118.94.dp
            CupSize.M -> 159.42.dp
            CupSize.L -> 199.9.dp
        },
        animationSpec = tween(durationMillis = 300)
    )

    val cupHeight by animateDpAsState(
        targetValue = when(coffeeCup.cupSize){
            CupSize.S -> 150.dp
            CupSize.M -> 197.dp
            CupSize.L -> 244.dp
        },
        animationSpec = tween(durationMillis = 300)
    )

    Box(
        modifier = modifier.fillMaxWidth().height(341.dp)
    ){
        Text(
            text = "200 ML",
            style = TextStyle(
                fontFamily = Urbanist,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                letterSpacing = 0.25.sp,
            ),
            color = HomeContent,
            modifier = Modifier.padding(top = 64.dp)
        )
        Image(
            painter = coffeeCup.img,
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center).width(cupWidth).height(cupHeight)
        )
        Image(
            painter = painterResource(R.drawable.coffe_logo),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 40.dp)
                .size(64.dp)
        )
    }
}

@Preview
@Composable
private fun CoffeeCupDetailsPreview(){
    val coffeeCup = CoffeeCup(
        id = 0,
        type = "Macchiato",
        img = painterResource(R.drawable.black),
        cupSize = CupSize.L
    )
    CoffeeCupDetails(coffeeCup)
}