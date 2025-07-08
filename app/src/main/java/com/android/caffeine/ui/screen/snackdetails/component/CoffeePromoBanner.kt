package com.android.caffeine.ui.screen.snackdetails.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.caffeine.R
import com.android.caffeine.ui.theme.PopUpButtonBackground
import com.android.caffeine.ui.theme.Sniglet


@Composable
fun CoffeePromoBanner(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.coffee_beans),
                contentDescription = null,
                modifier = Modifier.padding(end = 6.dp).size(32.dp)
            )
            Text(
                text = "More Espresso, Less Depresso",
                style = TextStyle(
                    fontFamily = Sniglet,
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp,
                    letterSpacing = 0.25.sp,
                    color = PopUpButtonBackground
                ),
                maxLines = 1,
            )
            Image(
                painter = painterResource(id = R.drawable.coffee_beans),
                contentDescription = "Coffee Bean",
                modifier = Modifier.padding(start = 6.dp).size(32.dp)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun CoffeePromoBannerPreview() {
        CoffeePromoBanner()
}