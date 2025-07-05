package com.android.caffeine.Screen.home.composablee

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.caffeine.R
import kotlinx.coroutines.delay

@Composable
fun CoffeeGhost () {

    var ghostPaddingTop by remember { mutableStateOf(43.dp) }

    LaunchedEffect(true) {
        while (true){
            if (ghostPaddingTop == 43.dp){
                ghostPaddingTop = 23.dp
            }else{
                ghostPaddingTop = 43.dp
            }
            delay(500L)
        }
    }

    val animatedGhostPaddingTop by animateDpAsState(
        targetValue = ghostPaddingTop,
        animationSpec = tween(durationMillis = 800),
    )

    Box(modifier = Modifier.fillMaxWidth()){
        Image(
            painter = painterResource(R.drawable.coffe_gost),
            contentDescription = "",
            modifier = Modifier
                .padding(top = animatedGhostPaddingTop)
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