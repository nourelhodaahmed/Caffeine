package com.android.caffeine.ui.screen.coffeetakeway

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.caffeine.R
import com.android.caffeine.ui.component.TopAppBar
import com.android.caffeine.ui.screen.coffeetakeway.component.CoffeeCover
import com.android.caffeine.ui.screen.coffeetakeway.component.CoffeeReady

@Composable
fun CoffeeTakeWay(){
    Box(
        modifier = Modifier
        .fillMaxSize()
        .background(color = White)
        .padding(horizontal = 16.dp)
        .verticalScroll(rememberScrollState())
    ){
        TopAppBar(
            modifier = Modifier.align(Alignment.TopCenter),
            startIcon = painterResource(R.drawable.cancel_round)
        )
        CoffeeReady(modifier = Modifier.align(Alignment.TopCenter).padding(top = 120.dp))
        Image(
            painter = painterResource(R.drawable.take_way_coffee),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 270.dp)
                .height(300.dp)
                .width(245.dp)
                .align(Alignment.TopCenter)
        )
        Image(
            painter = painterResource(R.drawable.coffe_logo),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 388.dp)
                .size(64.dp)
                .align(Alignment.TopCenter)
        )
        CoffeeCover(coverImage = R.drawable.black_cover, modifier = Modifier.align(Alignment.TopCenter))
    }
}

@Preview
@Composable
private fun CoffeeTakeWayPreview(){
    CoffeeTakeWay()
}