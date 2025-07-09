package com.android.caffeine.ui.screen.coffeetakeway.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.caffeine.R
import com.android.caffeine.ui.theme.PopUpButtonBackground
import com.android.caffeine.ui.theme.PopUpButtonDropShadow
import com.android.caffeine.ui.utils.dropShadow

@Composable
fun ReadyButton(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(56.dp)
            .background(color = PopUpButtonBackground, shape = CircleShape)
            .dropShadow(
                shape = CircleShape,
                color = PopUpButtonDropShadow,
                offsetY = 8.dp,
                blur = 16.dp,
                alpha = 0.5f
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.right_round),
            contentDescription = null,
            tint = Color(0xDEFFFFFF),
            modifier = Modifier.width(21.33.dp).height(17.33.dp)
        )
    }
}

@Preview
@Composable
private fun ReadyButtonPreview(){
    ReadyButton()
}