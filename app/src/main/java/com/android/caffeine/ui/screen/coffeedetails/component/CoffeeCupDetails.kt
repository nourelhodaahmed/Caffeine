package com.android.caffeine.ui.screen.coffeedetails.component

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
            CupSize.S -> 153.64.dp
            CupSize.M -> 199.4.dp
            CupSize.L -> 245.17.dp
        },
        animationSpec = tween(durationMillis = 300)
    )

    val cupHeight by animateDpAsState(
        targetValue = when(coffeeCup.cupSize){
            CupSize.S -> 188.dp
            CupSize.M -> 244.dp
            CupSize.L -> 300.dp
        },
        animationSpec = tween(durationMillis = 300)
    )

    val logoSize by animateDpAsState(
        targetValue = when(coffeeCup.cupSize){
            CupSize.S -> 40.dp
            CupSize.M -> 64.dp
            CupSize.L -> 66.dp
        },
        animationSpec = tween(durationMillis = 300)
    )

    val sizeText = when(coffeeCup.cupSize){
        CupSize.S -> 150
        CupSize.M -> 200
        CupSize.L -> 400
    }

    Box(
        modifier = modifier.fillMaxWidth().height(341.dp)
    ){
        Text(
            text = sizeText.toString() + " ML",
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
            painter = painterResource(coffeeCup.img),
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center).width(cupWidth).height(cupHeight)
        )
        Image(
            painter = painterResource(R.drawable.coffe_logo),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 40.dp)
                .size(logoSize)
        )
    }
}

@Preview
@Composable
private fun CoffeeCupDetailsPreview(){
    val coffeeCup = CoffeeCup(
        id = 0,
        type = "Macchiato",
        img = R.drawable.black,
        coverImg = R.drawable.black_cover,
        topImg = R.drawable.black_top,
        cupSize = CupSize.L
    )
    CoffeeCupDetails(coffeeCup)
}