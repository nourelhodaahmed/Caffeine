package com.android.caffeine.Screen.Home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.caffeine.R

@Composable
fun CoffeeGhost () {
    Box(modifier = Modifier.fillMaxWidth()){
        Image(
            painter = painterResource(R.drawable.coffe_ghost),
            contentDescription = "",
            modifier = Modifier
                .padding(top = 33.dp)
                .size(244.dp)
                .align(Alignment.Center)
        )
        Image(
            painter = painterResource(R.drawable.ghost_shadow),
            contentDescription = "",
            modifier = Modifier
                .padding(top = 279.44.dp)
                .width(177.31.dp)
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
private fun CoffeeGhostPreview(){
    CoffeeGhost()
}