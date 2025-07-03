package com.android.caffeine.Screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.caffeine.Screen.home.composable.CoffeeButton
import com.android.caffeine.Screen.home.composable.CoffeeGhost
import com.android.caffeine.Screen.home.composable.Content
import com.android.caffeine.Screen.home.composable.TopAppBar

@Composable
fun Home() {
    Column (
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
    ){
        TopAppBar()
        Content(modifier = Modifier.padding(top = 24.dp))
        CoffeeGhost()
        CoffeeButton(modifier = Modifier
            .padding(top = 58.91.dp)
            .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview
@Composable
private fun HomePreview() {
    Home()
}