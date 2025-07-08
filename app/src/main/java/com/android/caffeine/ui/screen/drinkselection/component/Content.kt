package com.example.coffeine.screen.drinkselection.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.android.caffeine.ui.theme.GrayText
import com.android.caffeine.ui.theme.ActionButton
import com.android.caffeine.ui.theme.HomeContent
import com.android.caffeine.ui.theme.Urbanist

@Composable
fun Content(){
    Text(
        text = "Good Morning",
        style = TextStyle(
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = 36.sp,
            lineHeight = 36.sp,
            letterSpacing = 0.25.sp,
            textAlign = TextAlign.Center,
        ),
        color = GrayText
    )

    Text(
        text = "Nour ☀",
        style = TextStyle(
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = 36.sp,
            lineHeight = 36.sp,
            letterSpacing = 0.25.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFF3B3B3B)
        ),
        color = ActionButton
    )

    Text(
        text = "What would you like to drink today?",
        style = TextStyle(
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = 16.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.25.sp,
            textAlign = TextAlign.Left,
        ),
        color = HomeContent
    )
}
