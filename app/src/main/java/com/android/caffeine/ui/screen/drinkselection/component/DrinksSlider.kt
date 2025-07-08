package com.example.coffeine.screen.drinkselection.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import com.android.caffeine.R
import com.android.caffeine.ui.model.CoffeeCup
import com.android.caffeine.ui.theme.Urbanist

@Composable
fun DrinksSlider(
    modifier: Modifier = Modifier,
    drinksList: List<CoffeeCup>,
    onClick: (String) -> Unit = {}
) {
    val pagerState = rememberPagerState(pageCount = { drinksList.size })

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val pageWidth = screenWidth * 0.54f
    val horizontalPadding = (screenWidth - pageWidth) / 2

    HorizontalPager(
        state = pagerState,
        pageSize = PageSize.Fixed(pageWidth),
        contentPadding = PaddingValues(horizontal = horizontalPadding),
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) { page ->
        DrinkCard(
            coffeeCup = drinksList[page],
            isCentered = page == pagerState.currentPage,
            onClick = onClick
        )
    }
}

@Composable
fun DrinkCard(
    coffeeCup: CoffeeCup,
    isCentered: Boolean,
    onClick: (String) -> Unit
) {
    val logoSize by animateDpAsState(
        targetValue = if (isCentered) 66.dp else 40.dp,
        animationSpec = tween(300, easing = FastOutSlowInEasing)
    )

    val logoOffsetY by animateDpAsState(
        targetValue = if (isCentered) 20.dp else 40.dp,
        animationSpec = tween(300, easing = FastOutSlowInEasing)
    )
    val scale by animateFloatAsState(
        targetValue = if (isCentered) 1f else 0.6f,
        animationSpec = tween(300, easing = FastOutSlowInEasing)
    )

    val density = LocalDensity.current
    val shiftPx = with(density) { 60.dp.toPx() }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(coffeeCup.id.toString()) },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(coffeeCup.img),
                contentDescription = "caffeeImg",
                modifier = Modifier.graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    translationY = (1f - scale) * shiftPx
                }
            )
            Image(
                painter = painterResource(id = if (isCentered) R.drawable.coffe_logo else R.drawable.coffe_logo),
                contentDescription = if (isCentered) "Logo" else "Small Logo",
                modifier = Modifier
                    .size(logoSize)
                    .offset(y = logoOffsetY)
                    .border(1.dp, Color(0xFF007855), CircleShape)
                    .background(Color.White, CircleShape)
            )
        }

        Text(
            text = coffeeCup.type,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            letterSpacing = 0.25.sp,
            lineHeight = 32.sp,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
    }
}