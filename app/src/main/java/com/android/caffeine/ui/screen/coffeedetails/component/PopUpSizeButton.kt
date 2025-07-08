package com.android.caffeine.ui.screen.coffeedetails.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.caffeine.ui.theme.PopUpButtonBackground
import com.android.caffeine.ui.theme.PopUpButtonDropShadow
import com.android.caffeine.ui.theme.PopUpButtonNonSelectedText
import com.android.caffeine.ui.theme.PopUpButtonSelectedText
import com.android.caffeine.ui.theme.Urbanist
import com.android.caffeine.ui.utils.dropShadow

@Composable
fun PopUpSizeButton(
    isSelected: Boolean,
    index: Int,
    text: String,
    onClickButton: (Int) -> Unit,
) {
    val textColor by animateColorAsState(
        targetValue = if (isSelected) PopUpButtonSelectedText else PopUpButtonNonSelectedText,
        animationSpec = tween(durationMillis = 300)
    )
    Box(
        modifier = Modifier
            .size(40.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { onClickButton(index) }
            ),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = isSelected,
            enter = fadeIn(animationSpec = tween(durationMillis = 700)),
            exit = fadeOut(animationSpec = tween(durationMillis = 700))
        ) {
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
                    )
            )
        }
        Text(
            text = text,
            style = TextStyle(
                fontFamily = Urbanist,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            ),
            color = textColor,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview
@Composable
private fun PopUpSizeButtonPreview(){
    PopUpSizeButton(
        isSelected = true,
        index = 0,
        text = "S",
        onClickButton = {}
    )
}