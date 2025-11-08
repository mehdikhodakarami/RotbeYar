package com.rotbeyar.app.presentation.feture.onboarding.componants

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rotbeyar.app.R
import com.rotbeyar.app.presentation.common.component.RotbeYarCard
import com.rotbeyar.app.ui.theme.PrimaryPurple
import com.rotbeyar.app.ui.theme.cardElevationApp

@Composable
fun AnimatedRotbeYarLogo() {
    var startAnimation by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0.8f,
        animationSpec = tween(
            durationMillis = 800,
            easing = {
                OvershootInterpolator(2f).getInterpolation(it)
            }
        )
    )

    val alpha by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(800)
    )

    LaunchedEffect(Unit) {
        startAnimation = true
    }

    RotbeYarCard(
        modifier = Modifier
            .padding(start = 24.dp)
            .size(96.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale,
                alpha = alpha
            ),
        onClick = {},
        shape = CircleShape,
        elevation = 0.dp,
    ) {
        Image(
            painter = painterResource(id = R.drawable.main_icon),
            contentDescription = "Logo",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize(),
            colorFilter = ColorFilter.tint(PrimaryPurple)
        )
    }
}