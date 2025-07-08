package com.android.caffeine.ui.screen.snackdetails.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CustomImage(mageResId: Int) {
    Image(
        painter = painterResource(id = mageResId),
        contentDescription = "Custom Image",
        modifier = Modifier
            .size(width = 300.dp, height = 310.dp)
    )
}