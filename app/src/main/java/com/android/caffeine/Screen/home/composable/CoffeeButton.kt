package com.android.caffeine.Screen.home.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.caffeine.R
import com.android.caffeine.ui.theme.HomeButton
import com.android.caffeine.ui.theme.HomeButtonContent
import com.android.caffeine.ui.theme.Urbanist

@Composable
fun CoffeeButton(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(color = HomeButton, shape = CircleShape)
            .padding(horizontal = 32.dp, vertical = 16.dp)
    ) {
        Row (
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Text(
                text = "bring my coffee",
                style = TextStyle(
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    letterSpacing = 0.25.sp,
                ),
                color = HomeButtonContent,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Icon(
                painter = painterResource(R.drawable.coffee),
                contentDescription = "",
                tint = HomeButtonContent,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview
@Composable
private fun CoffeeButtonPreview() {
    CoffeeButton()
}