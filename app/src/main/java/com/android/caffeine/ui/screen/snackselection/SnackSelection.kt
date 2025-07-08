package com.android.caffeine.ui.screen.snackselection

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.caffeine.ui.component.TopAppBar
import com.android.caffeine.ui.screen.snackselection.component.VerticalSnackPager
import com.android.caffeine.ui.theme.Urbanist
import com.android.caffeine.R


@Composable
fun SnackSelection() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            TopAppBar(startIcon = painterResource(R.drawable.cancel_round))

            Spacer(modifier = Modifier.height(56.dp))
            Text(
                text = "Take your snack",
                fontFamily = Urbanist,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                letterSpacing = 0.25.sp,
                lineHeight = 32.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            VerticalSnackPager()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SnackSelectionPreview() {
    SnackSelection()
}