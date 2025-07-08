package com.android.caffeine.ui.screen.coffeedetails

import AnimatedWaveImage
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.android.caffeine.R
import com.android.caffeine.ui.component.ActionButton
import com.android.caffeine.ui.component.TopAppBar
import com.android.caffeine.ui.model.CupSize
import com.android.caffeine.ui.screen.coffeedetails.component.CoffeeCupDetails
import com.android.caffeine.ui.screen.coffeedetails.component.DrippingCoffee
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
import com.example.coffeine.CoffeeProgressComponent
import org.koin.androidx.compose.koinViewModel

@Composable
fun CoffeeDetails(
    navController: NavController,
    cupId: String,
    viewModel: CoffeeDetailsViewModel = koinViewModel()
) {
    LaunchedEffect(true) {
        viewModel.setCoffeeCup(cupId.toInt())
    }
    val coffeeCup = viewModel.state.collectAsState().value.coffeeCup
    val selectedCaffeine = viewModel.state.collectAsState().value.selectedCaffeine
    val isBringCoffeeButtonClicked = viewModel.state.collectAsState().value.isBringCoffeeButtonClicked


    var CupSizeButtonIndex = cupSizeToIndex(coffeeCup.cupSize)
    var caffeineSizeIndex = caffeieneSizeToIndex(selectedCaffeine)

    val caffeineSize by animateDpAsState(
        targetValue = when(coffeeCup.cupSize){
            CupSize.S -> 100.dp
            CupSize.M -> 130.dp
            CupSize.L -> 180.dp
        },
        animationSpec = tween(durationMillis = 300)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        caffeineListSize.forEachIndexed { index, size ->
            AnimatedVisibility(
                visible = coffeeCup.caffeineSize.contains(size),
                enter = slideInVertically (animationSpec = tween(durationMillis = 1000))
                        + fadeIn(animationSpec = tween(durationMillis = 1000)),
                exit = slideOutVertically (animationSpec = tween(durationMillis = 1000))
                        + fadeOut(animationSpec = tween(durationMillis = 1000)),
            ) {
                DrippingCoffee(modifier = Modifier.align(Alignment.TopCenter), caffeineSize = caffeineSize)
            }
        }

        AnimatedVisibility(
            visible = !isBringCoffeeButtonClicked,
            enter = slideInVertically(animationSpec = tween(1000))
                    + fadeIn(animationSpec = tween(1000)),

            exit = slideOutVertically(animationSpec = tween(1000))
                    + fadeOut(animationSpec = tween(1000)),
            modifier = Modifier.align(Alignment.TopCenter)
        ){
            TopAppBar(
                modifier = Modifier.align(Alignment.TopCenter),
                startIcon = painterResource(R.drawable.arrow_left_round),
                title = coffeeCup.type,
            )
        }

        CoffeeCupDetails(
            modifier = Modifier.padding(top = 120.dp).align(Alignment.TopCenter),
            coffeeCup = coffeeCup
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = 460.dp),
        ){
            AnimatedVisibility(
                visible = !isBringCoffeeButtonClicked,
                enter = slideInVertically(
                    animationSpec = tween(1000),
                    initialOffsetY = { fullHeight -> fullHeight }
                ) + fadeIn(animationSpec = tween(1000)),

                exit = slideOutVertically(
                    animationSpec = tween(1000),
                    targetOffsetY = { fullHeight -> fullHeight }
                ) + fadeOut(animationSpec = tween(1000)),
                modifier = Modifier.align(Alignment.TopCenter)
            ) {
                Column(
                    modifier = Modifier
                        .width(IntrinsicSize.Max)
                        .align(Alignment.Center)
                        .padding(start = 30.dp)
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
                    modifier = Modifier.padding(top = 234.dp),
                    onClick = {viewModel.onBringCoffeeButtonClicked()}
                )
            }

            AnimatedVisibility(
                visible = isBringCoffeeButtonClicked,
                enter = slideInVertically(
                    animationSpec = tween(1000),
                    initialOffsetY = { fullHeight -> fullHeight }
                ) + fadeIn(animationSpec = tween(1000)),

                exit = slideOutVertically(
                    animationSpec = tween(1000),
                    targetOffsetY = { fullHeight -> fullHeight }
                ) + fadeOut(animationSpec = tween(1000)),
                modifier = Modifier.align(Alignment.TopCenter)
            ){
                Column {
                    AnimatedWaveImage()
                    CoffeeProgressComponent(Modifier.padding(top = 37.dp))
                }
            }

        }
    }
}