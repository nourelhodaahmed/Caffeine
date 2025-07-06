package com.android.caffeine.screen.coffeedetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.caffeine.R
import com.android.caffeine.component.ActionButton
import com.android.caffeine.component.TopAppBar
import com.android.caffeine.model.CoffeeCup
import com.android.caffeine.model.CupSize
import com.android.caffeine.screen.coffeedetails.component.CoffeeCupDetails
import com.android.caffeine.screen.coffeedetails.component.PopUpButtons
import com.android.caffeine.screen.coffeedetails.component.PopUpCoffeeButton
import com.android.caffeine.screen.coffeedetails.component.PopUpSizeButton
import com.android.caffeine.ui.theme.PopUpTextDescription
import com.android.caffeine.ui.theme.Urbanist

@Composable
fun CoffeeDetails() {
    val coffeeCup = CoffeeCup(
        id = 0,
        type = "Macchiato",
        img = painterResource(R.drawable.black),
        cupSize = CupSize.L
    )

    var CupSizeButtonIndex by remember { mutableIntStateOf(0) }
    var caffeineSizeIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            modifier = Modifier.padding(bottom = 16.dp),
            startIcon = painterResource(R.drawable.arrow_left_round),
            title = "Macchiato"
        )

        CoffeeCupDetails(coffeeCup)

        Column(modifier = Modifier.width(IntrinsicSize.Max)) {
            PopUpButtons(
                selectedButtonIndex = CupSizeButtonIndex,
                onClickButton = { CupSizeButtonIndex = it },
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
            PopUpButtons(
                modifier = Modifier.padding(top = 16.dp),
                selectedButtonIndex = caffeineSizeIndex,
                onClickButton = { caffeineSizeIndex = it },
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                listOf("Low", "Medium", "High").forEach {
                    Text(
                        text = it,
                        style = TextStyle(
                            fontFamily = Urbanist,
                            fontWeight = FontWeight.Medium,
                            fontSize = 10.sp,
                            letterSpacing = 0.25.sp,
                        ),
                        color = PopUpTextDescription,
                    )
                }
            }
        }

        ActionButton(
            text = "bring my coffee",
            endIcon = painterResource(R.drawable.coffee),
            modifier = Modifier.padding(top = 92.dp)
        )
    }
}

@Preview
@Composable
private fun CoffeeDetailsPreview() {
    CoffeeDetails()
}
