package com.android.caffeine.Screen.coffeedetails.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.caffeine.ui.theme.PopUpButtonBackground
import com.android.caffeine.ui.theme.PopUpButtonNonSelectedText
import com.android.caffeine.ui.theme.PopUpButtonSelectedText
import com.android.caffeine.ui.theme.PopUpButtonsBackground
import com.android.caffeine.ui.theme.Urbanist

@Composable
fun PopUpButtons (
    buttons: List<String>,
    selectedButtonIndex: Int,
    onClickButton: (Int) -> Unit,
    modifier: Modifier = Modifier,
    buttonsDescription: List<String>? = null,
) {
    Row(
        modifier= modifier
            .background(color = PopUpButtonsBackground, shape = CircleShape)
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        buttons.forEachIndexed{ index, text ->

            val textColor by animateColorAsState(
                targetValue = if (selectedButtonIndex == index) PopUpButtonSelectedText else PopUpButtonNonSelectedText,
                animationSpec = tween(durationMillis = 300)
            )
            PopUpButton(
                selectedButtonIndex = selectedButtonIndex,
                index = index,
                text = text,
                onClickButton = onClickButton,
                textColor = textColor
            )
        }
    }
}

@Composable
private fun PopUpButton(
    selectedButtonIndex: Int,
    index: Int,
    text: String,
    onClickButton: (Int) -> Unit,
    textColor: Color
){
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { onClickButton(index) }
            ),
        contentAlignment = Alignment.Center
    ){
        AnimatedVisibility(
            visible = selectedButtonIndex == index,
            enter = fadeIn(animationSpec = tween(durationMillis = 700)),
            exit = fadeOut(animationSpec = tween(durationMillis = 700))
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(color = PopUpButtonBackground, shape = CircleShape)
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
private fun PopUpButtonsPreview(){
    val buttons = listOf("S", "M", "L")
    var selectedIndex by remember { mutableIntStateOf(0) }
    PopUpButtons(
        buttons = buttons,
        selectedButtonIndex = selectedIndex,
        onClickButton = {selectedIndex = it},
    )
}