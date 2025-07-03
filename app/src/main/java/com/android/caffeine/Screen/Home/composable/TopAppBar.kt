package com.android.caffeine.Screen.Home.composable

import com.android.caffeine.R
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.caffeine.ui.theme.TopBarButtonBackground

@Composable
fun TopAppBar(){
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).padding(top = 56.dp),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween
    ) {
        Box(
            modifier = Modifier.size(48.dp).clip(CircleShape)
        ){
            Image(
                painter = painterResource(R.drawable.profile_img),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
        }

        Box(
            modifier = Modifier.size(48.dp).background(color = TopBarButtonBackground,shape = CircleShape)
        ){
            Icon(
                painter = painterResource(R.drawable.plus_round),
                contentDescription = null,
                modifier = Modifier.size(24.dp).align(Alignment.Center)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun TopAppBarPreview(){
    TopAppBar()
}