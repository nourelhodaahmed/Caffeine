package com.android.caffeine.Screen.Home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.caffeine.Screen.Home.composable.CoffeeGhost
import com.android.caffeine.Screen.Home.composable.Content
import com.android.caffeine.Screen.Home.composable.TopAppBar

@Composable
fun Home() {
    Column (
        modifier = Modifier.fillMaxSize()
    ){
        TopAppBar()
        Content(modifier = Modifier.padding(top = 24.dp))
        CoffeeGhost()
    }
}

@Preview
@Composable
private fun HomePreview() {
    Home()
}