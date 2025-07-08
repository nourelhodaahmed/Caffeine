package com.android.caffeine.ui.screen.snackselection.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun CardSnack(
    imageRes: Int,
    snackId: Int,
    contentDescription: String,
    scale: Float,
    rotationZ: Float,
    offsetY: Dp,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .offset(y = offsetY)
            .graphicsLayer(
                scaleX = scale * 1.5f,
                scaleY = scale,
                rotationZ = rotationZ,
            )
            .clickable(onClick = { onClick(snackId.toString()) })
    ) {
        Box(
            modifier = Modifier
                .width(195.31.dp)
                .height(205.5.dp)
                .clip(RoundedCornerShape(topEnd = 32.dp, bottomEnd = 32.dp))
                .background(Color(0xFFF5F5F5))
                .shadow(
                    elevation = 3.dp,
                    shape = RoundedCornerShape(topEnd = 32.dp, bottomEnd = 32.dp),
                    ambientColor = Color(0x1F000000),
                    spotColor = Color(0x1F000000)
                )
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale,
                    rotationZ = rotationZ,
                    alpha = 1f
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 1500,
                        easing = FastOutSlowInEasing
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = contentDescription,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(134.23.dp)
                    .height(139.dp)
            )
        }
    }
}