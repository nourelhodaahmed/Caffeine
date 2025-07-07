package com.android.caffeine.ui.screen.coffeedetails

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOut
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.caffeine.R
import com.android.caffeine.ui.component.ActionButton
import com.android.caffeine.ui.component.TopAppBar
import com.android.caffeine.ui.model.CaffeineSize
import com.android.caffeine.ui.model.CupSize
import com.android.caffeine.ui.screen.coffeedetails.component.CoffeeCupDetails
import com.android.caffeine.ui.screen.coffeedetails.component.PopUpButtons
import com.android.caffeine.ui.screen.coffeedetails.component.PopUpCoffeeButton
import com.android.caffeine.ui.screen.coffeedetails.component.PopUpSizeButton
import com.android.caffeine.ui.screen.coffeedetails.utils.caffeieneSizeToIndex
import com.android.caffeine.ui.screen.coffeedetails.utils.caffeineListSize
import com.android.caffeine.ui.screen.coffeedetails.utils.cupSizeToIndex
import com.android.caffeine.ui.screen.coffeedetails.utils.indexToCupSize
import com.android.caffeine.ui.screen.coffeedetails.utils.indexToCaffeieneSize
import com.android.caffeine.ui.theme.PopUpTextDescription
import com.android.caffeine.ui.theme.Urbanist
import org.koin.androidx.compose.koinViewModel

@Composable
fun CoffeeDetails(viewModel: CoffeeDetailsViewModel = koinViewModel()) {
    val coffeeCup = viewModel.state.collectAsState().value.coffeeCup
    val selectedCaffeine = viewModel.state.collectAsState().value.selectedCaffeine

    var CupSizeButtonIndex = cupSizeToIndex(coffeeCup.cupSize)
    var caffeineSizeIndex = caffeieneSizeToIndex(selectedCaffeine)

    val caffeineSize = when (indexToCupSize(CupSizeButtonIndex)){
        CupSize.S -> 100.dp
        CupSize.M -> 150.dp
        CupSize.L -> 200.dp
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
            .padding(horizontal = 16.dp),
    ) {
        caffeineListSize.forEachIndexed { index, size ->
            AnimatedVisibility(
                visible = coffeeCup.caffeineSize.contains(size),
                enter = slideInVertically { -it } + fadeIn(),
                exit = slideOutVertically { -it } + fadeOut(),
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.TopCenter)
                ) {
                    Image(
                        painter = painterResource(R.drawable.coffe_dripping),
                        contentDescription = null,
                        modifier = Modifier.size(caffeineSize)
                    )
                }
            }
        }

        TopAppBar(
            modifier = Modifier.align(Alignment.TopCenter),
            startIcon = painterResource(R.drawable.arrow_left_round),
            title = coffeeCup.type,
        )

        CoffeeCupDetails(
            modifier = Modifier.padding(top = 120.dp).align(Alignment.TopCenter),
            coffeeCup = coffeeCup
        )

        Column(
            modifier = Modifier
            .width(IntrinsicSize.Max)
            .padding(bottom = 198.dp)
            .align(Alignment.BottomCenter)
        ) {
            PopUpButtons(
                selectedButtonIndex = CupSizeButtonIndex,
                onClickButton = { viewModel.onChangeCupSize(indexToCupSize(it)) },
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
                onClickButton = { viewModel.onChangeCaffeineSize(indexToCaffeieneSize(it)) },
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
            modifier = Modifier.padding(bottom = 50.dp).align(Alignment.BottomCenter)
        )
    }
}

@Preview
@Composable
private fun CoffeeDetailsPreview() {
    CoffeeDetails()
}
