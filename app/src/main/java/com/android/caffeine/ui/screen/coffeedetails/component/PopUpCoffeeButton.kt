package com.android.caffeine.ui.screen.coffeedetails.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.android.caffeine.ui.theme.PopUpButtonBackground
import com.android.caffeine.ui.theme.PopUpButtonDropShadow
import com.android.caffeine.ui.theme.PopUpButtonSelectedText
import com.android.caffeine.ui.utils.dropShadow

@Composable
fun PopUpCoffeeButton(
    isSelected: Boolean,
    index: Int,
    icon: Painter,
    onClickButton: (Int) -> Unit,
) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { onClickButton(index) }
            ),
        contentAlignment = Alignment.Center
    ){
        AnimatedVisibility(
            visible = isSelected,
            enter = fadeIn(animationSpec = tween(durationMillis = 700)),
            exit = fadeOut(animationSpec = tween(durationMillis = 700))
        ){
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(color = PopUpButtonBackground, shape = CircleShape)
                    .dropShadow(
                        shape = CircleShape,
                        color = PopUpButtonDropShadow,
                        offsetY = 8.dp,
                        blur = 16.dp,
                        alpha = 0.5f
                    ),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    painter = icon,
                    contentDescription = null,
                    tint = PopUpButtonSelectedText,
                    modifier = Modifier.size(19.5.dp)
                )
            }
        }
    }
}