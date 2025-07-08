import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.caffeine.R
import kotlinx.coroutines.delay

@Composable
fun AnimatedWaveImage() {
    var animate by remember { mutableStateOf(false) }
    var show by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        animate = true
        delay(3000L)
        animate = false
        delay(3000L)
        show = false
    }

    if (show) {
        AnimatedVisibility(
            visible = animate,
            enter = slideInHorizontally(animationSpec = tween(3000)),
            exit = slideOutHorizontally(
                animationSpec = tween(3000),
                targetOffsetX = { fullHeight -> -fullHeight }
            )
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.line),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(32.dp)
                )
            }
        }
    }
}