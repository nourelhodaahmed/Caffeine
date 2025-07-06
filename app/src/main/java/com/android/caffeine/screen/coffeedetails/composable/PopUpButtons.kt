package com.android.caffeine.screen.coffeedetails.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.caffeine.R
import com.android.caffeine.ui.theme.PopUpButtonsBackground

@Composable
fun PopUpButtons(
    selectedButtonIndex: Int,
    onClickButton: (Int) -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable (selectedIndex: Int, onClickButton: (Int) -> Unit) -> Unit
) {
    Row(
        modifier = modifier
            .background(color = PopUpButtonsBackground, shape = CircleShape)
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        content(selectedButtonIndex, onClickButton)
    }
}
@Preview
@Composable
private fun PopUpButtonsPreview() {
    var selectedIndex by remember { mutableIntStateOf(0) }
    PopUpButtons(
        selectedButtonIndex = selectedIndex,
        onClickButton = { selectedIndex = it },
    ) { selectedIndex, onClick ->
        val buttons = listOf("S", "M", "L")
        buttons.forEachIndexed { index, text ->
            PopUpSizeButton(
                isSelected = selectedIndex == index,
                index = index,
                text = text,
                onClickButton = onClick,
            )
        }
    }
}

@Preview
@Composable
private fun PopUpButtonsPreview2() {
    var selectedIndex by remember { mutableIntStateOf(0) }
    PopUpButtons(
        selectedButtonIndex = selectedIndex,
        onClickButton = { selectedIndex = it },
    ) { selectedIndex, onClick ->
        val buttons = listOf(
            painterResource(R.drawable.coffee_icon_round),
            painterResource(R.drawable.coffee_icon_round),
            painterResource(R.drawable.coffee_icon_round)
        )
        buttons.forEachIndexed { index, icon ->
            PopUpCoffeeButton(
                isSelected = selectedIndex == index,
                index = index,
                icon = icon,
                onClickButton = onClick,
            )
        }
    }
}