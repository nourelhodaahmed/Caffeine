package com.android.caffeine.ui.screen.coffeetakeway.component

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.TextStyle
import com.android.caffeine.ui.theme.Urbanist

@Composable
fun CoffeeSwitch(
    selected: Boolean,
    onToggle: () -> Unit,
    coffeeTop: Int,
    modifier: Modifier = Modifier,
) {
    val toggleBackgroundColor by updateTransition(selected)
        .animateColor(
            transitionSpec = { tween(500, easing = FastOutSlowInEasing) },
        ) { if (it) Color(0xFF7C351B) else Color(0xFFFFEEE7) }

    Row(
        modifier = modifier
            .background(toggleBackgroundColor, CircleShape)
            .clipToBounds()
    ) {
        AnimatedContent(
            targetState = selected,
            transitionSpec = {
                val slideIn  = slideInHorizontally(
                    initialOffsetX = { if (targetState)  it else -it},
                    animationSpec  = tween(500, easing = FastOutSlowInEasing)
                )
                val slideOut = slideOutHorizontally(
                    targetOffsetX = { if (targetState)  it else -it},
                    animationSpec = tween(500, easing = FastOutSlowInEasing)
                )
                slideIn togetherWith slideOut using SizeTransform(clip = true)

            },
        ) { isOn ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                if (isOn) {
                    CoffeeTopImage(onToggle, coffeeTop)
                    CoffeeOnOrOff("ON", Color(0x99FFFFFF))
                } else {
                    CoffeeTopImage(onToggle, coffeeTop)
                    CoffeeOnOrOff("OFF", Color(0x99000000))
                }
            }
        }
    }
}

@Composable
private fun CoffeeTopImage(onToggle: () -> Unit, coffeeTop: Int) {
    Image(
        painter = painterResource(coffeeTop),
        contentDescription = null,
        modifier = Modifier
            .size(40.dp)
            .clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
            onClick = onToggle
        )
    )
}

@Composable
private fun CoffeeOnOrOff(text: String, textColor: Color) {
    Text(
        text = text,
        style = TextStyle(
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 10.sp,
            letterSpacing = 0.25.sp,
        ),
        color = textColor,
        modifier = Modifier.padding(horizontal = 14.dp)
    )
}