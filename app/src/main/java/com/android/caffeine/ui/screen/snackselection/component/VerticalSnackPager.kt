package com.android.caffeine.ui.screen.snackselection.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.compose.ui.zIndex
import com.android.caffeine.data.snacks
import kotlin.math.abs

@Composable
fun VerticalSnackPager(
    onItemClick : (String) -> Unit
) {
    val pagerState = rememberPagerState(initialPage = 1, pageCount = { snacks.size })
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val itemWidth = 260.38.dp
    val contentPadding = (screenWidth - itemWidth) / 2

    VerticalPager(
        state = pagerState,
        pageSize = PageSize.Fixed(itemWidth),
        contentPadding = PaddingValues(
            horizontal = contentPadding,
            vertical = 100.dp
        ),
        modifier = Modifier
            .height(450.dp)
            .width(400.dp)
            .offset(x=-80.dp)
            .zIndex(1f)
    ) { index ->
        val pageOffset = (pagerState.currentPage - index) + pagerState.currentPageOffsetFraction
        val absOffset = abs(pageOffset)

        val scale = 1f - (absOffset * 1f).coerceAtMost(0.1f)
        val rotationZ = pageOffset * -5f
        val offsetY = (pageOffset * 70.dp).coerceIn((-160).dp, 160.dp)

        CardSnack(
            imageRes = snacks[index].img,
            snackId = snacks[index].id,
            contentDescription = snacks[index].name,
            scale = scale,
            rotationZ = rotationZ,
            offsetY = offsetY,
            onClick = {id -> onItemClick(id)}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SnackSelectionScreenPreview() {
    VerticalSnackPager({})
}