package com.android.caffeine.ui.screen.snackdetails.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Icon
import com.android.caffeine.R
import com.android.caffeine.ui.theme.HomeContent
import com.android.caffeine.ui.theme.Urbanist

@Composable
fun BonAppetit() {
    Row(
        modifier = Modifier
            .width(150.dp)
            .height(26.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Bon appétit",
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            letterSpacing = 0.25.sp,
            color = HomeContent,
            modifier = Modifier.padding(end = 8.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.magic_round),
            contentDescription = null,
       )
    }
}

@Preview(showBackground = true)
@Composable
private fun BonAppetitPreview() {
    BonAppetit()
}