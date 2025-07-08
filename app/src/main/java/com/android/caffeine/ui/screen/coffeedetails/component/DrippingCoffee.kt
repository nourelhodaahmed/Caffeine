package com.android.caffeine.ui.screen.coffeedetails.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.android.caffeine.R

@Composable
fun DrippingCoffee(
    modifier: Modifier = Modifier,
    caffeineSize: Dp = 100.dp
) {
    Box(modifier = modifier
        .fillMaxWidth()
        .padding(top = 200.dp)
        .height(300.dp)
    ){
        Image(
            painter = painterResource(R.drawable.coffe_dripping),
            contentDescription = null,
            modifier = Modifier.size(caffeineSize).align(Alignment.TopCenter)
        )
    }
}

@Preview
@Composable
private fun DrippingCoffeePreview(){
    DrippingCoffee()
}