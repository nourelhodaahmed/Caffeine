package com.android.caffeine.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.caffeine.R
import com.android.caffeine.composable.ActionButton
import com.android.caffeine.screen.home.composablee.CoffeeGhost
import com.android.caffeine.screen.home.composablee.Content
import com.android.caffeine.composable.TopAppBar

@Composable
fun Home() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ){
        TopAppBar(profileImage = painterResource(R.drawable.profile_img), endIcon = painterResource(R.drawable.plus_round))
        Content(modifier = Modifier.padding(top = 24.dp))
        CoffeeGhost()
        ActionButton(
            text = "bring my coffee",
            endIcon = painterResource(R.drawable.coffee),
            modifier = Modifier
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