package com.android.caffeine.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.caffeine.R
import com.android.caffeine.ui.theme.HomeContent
import com.android.caffeine.ui.theme.TopBarButtonBackground
import com.android.caffeine.ui.theme.Urbanist

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    profileImage: Painter? = null,
    startIcon: Painter? = null,
    title: String? = null,
    endIcon: Painter? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 56.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (profileImage != null) {
            Image(
                painter = profileImage,
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )
        }
        Box(modifier = Modifier.weight(1f)){
            if (title != null){
                Text(
                    text = title,
                    style = TextStyle(
                        fontFamily = Urbanist,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        letterSpacing = 0.25.sp,
                    ),
                    color = HomeContent,
                )
            }
        }
        if (startIcon != null) {
            TopAppBarIcon(startIcon)
        }
        if (endIcon != null) {
            TopAppBarIcon(endIcon)
        }
    }
}

@Composable
private fun TopAppBarIcon(Icon: Painter) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .background(color = TopBarButtonBackground, shape = CircleShape)
    ) {
        Icon(
            painter = Icon,
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TopAppBarPreview() {
    TopAppBar(
        profileImage = painterResource(R.drawable.profile_img),
        title = "Macchiato",
        endIcon = painterResource(R.drawable.plus_round)
    )
}