package com.android.caffeine.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.caffeine.R
import com.android.caffeine.ui.theme.ActionButton
import com.android.caffeine.ui.theme.ActionButtonContent
import com.android.caffeine.ui.theme.ActionButtonShadow
import com.android.caffeine.ui.theme.Urbanist

@Composable
fun ActionButton(
    text: String,
    endIcon: Painter,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Row (
        modifier = modifier
            .shadow(elevation = 12.dp,spotColor = ActionButtonShadow, ambientColor = ActionButtonShadow)
            .background(color = ActionButton, shape = CircleShape)
            .clip(CircleShape)
            .clickable(onClick = onClick)
            .padding(horizontal = 32.dp, vertical = 16.dp)
        ,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Text(
            text = text,
            style = TextStyle(
                fontFamily = Urbanist,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                letterSpacing = 0.25.sp,
            ),
            color = ActionButtonContent,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Icon(
            painter = endIcon,
            contentDescription = "",
            tint = ActionButtonContent,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview
@Composable
private fun ActionButtonPreview() {
    ActionButton(text = "bring my coffee",painterResource(R.drawable.coffee))
}