package com.android.caffeine.ui.screen.coffeetakeway.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.caffeine.R

@Composable
fun CoffeeCover (
    coverImage: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 269.dp)
            .height(338.dp)
    ){
        Image(
            painter = painterResource(coverImage),
            contentDescription = null,
            modifier = Modifier.height(69.dp).width(260.dp).align(Alignment.TopCenter)
        )
    }
}

@Preview
@Composable
private fun CoffeeCoverPreview(){
    CoffeeCover(R.drawable.black_cover)
}