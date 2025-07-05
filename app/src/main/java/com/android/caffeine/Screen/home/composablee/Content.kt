package com.android.caffeine.Screen.home.composablee

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.caffeine.ui.theme.HomeContent
import com.android.caffeine.ui.theme.Sniglet
import com.android.caffeine.R
import kotlinx.coroutines.delay

@Composable
fun Content(
    modifier: Modifier = Modifier,
) {
    var showStars by remember { mutableStateOf(true) }
    LaunchedEffect(true) {
        while (true) {
            delay(500L)
            showStars = !showStars
        }
    }
    Box(modifier = modifier.fillMaxWidth()) {
        Text(
            text = "Hocus\n" +
                    "Pocus\n" +
                    "I Need Coffee\n" +
                    "to Focus",
            style = TextStyle(
                fontFamily = Sniglet,
                fontWeight = FontWeight.Normal,
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
                letterSpacing = 0.25.sp,
                lineHeight = 50.sp
            ),
            color = HomeContent,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(bottom = 2.dp)
        )

        if (showStars) {
            Icon(
                painter = painterResource(R.drawable.star),
                contentDescription = "",
                tint = HomeContent,
                modifier = Modifier
                    .padding(top = 6.dp, end = 90.dp)
                    .size(16.dp)
                    .align(Alignment.TopEnd)
            )
            Icon(
                painter = painterResource(R.drawable.star),
                contentDescription = "",
                tint = HomeContent,
                modifier = Modifier
                    .padding(top = 6.dp, end = 76.dp)
                    .size(16.dp)
                    .align(Alignment.BottomEnd)
            )
            Icon(
                painter = painterResource(R.drawable.star),
                contentDescription = "",
                tint = HomeContent,
                modifier = Modifier
                    .padding(top = 65.dp, start = 91.dp)
                    .size(16.dp)
                    .align(Alignment.TopStart)
            )
        }
    }
}

@Preview(widthDp = 360)
@Composable
private fun ContentPreview() {
    Content()
}