package com.example.coffeine

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.android.caffeine.ui.theme.Urbanist
import com.android.caffeine.R

@Composable
fun CoffeeProgressComponent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .width(202.dp)
            .height(105.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Column(
            modifier = Modifier
                .width(202.dp)
                .height(53.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Almost Done",
                modifier = Modifier
                    .width(202.dp)
                    .wrapContentSize(Alignment.Center),
                fontFamily = Urbanist,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Your coffee will be finish in",
                modifier = Modifier
                    .width(202.dp)
                    .height(19.dp)
                    .wrapContentSize(Alignment.Center),
                fontFamily = Urbanist,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center,
                color=Color(0x4C1F1F1F)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .wrapContentSize(Alignment.Center)
                .padding(horizontal = 7.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "CO",
                modifier = Modifier
                    .height(40.dp)
                    .wrapContentSize(Alignment.Center),
                style = TextStyle(
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 32.sp,
                    letterSpacing = 0.25.sp,
                ),
                color = Color(0xFF7C351B)
            )

            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .weight(1f),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(R.drawable.point),
                    contentDescription = "Point separator",
                    modifier = Modifier
                        .size(4.dp, 12.dp)
                )

            }
            Text(
                text = "FF",
                modifier = Modifier
                    .height(40.dp)
                    .wrapContentSize(Alignment.Center),
                style = TextStyle(
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 32.sp,
                    letterSpacing = 0.25.sp,
                ),
                color = Color(0xFF7C351B)
            )

            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .weight(1f),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(id = R.drawable.point),
                    contentDescription = "Point separator",
                    modifier = Modifier
                        .size(4.dp, 12.dp)
                )

            }
            Text(
                text = "EE",
                modifier = Modifier
                    .height(40.dp)
                    .wrapContentSize(Alignment.Center),
                style = TextStyle(
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 32.sp,
                    letterSpacing = 0.25.sp,
                ),
                color = Color(0xFF7C351B)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoffeeProgressComponentPreview() {
    CoffeeProgressComponent()
}