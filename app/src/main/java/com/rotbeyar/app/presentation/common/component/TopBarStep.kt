package com.rotbeyar.app.presentation.common.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun StepProgressBar(
    modifier: Modifier = Modifier,
    totalSteps: Int = 5,
    currentStep: Int = 3
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (step in 1..totalSteps) {
            StepItem(
                step = step,
                isCompleted = step < currentStep,
                isCurrent = step == currentStep,
                isLast = step == totalSteps
            )
        }
    }
}

@Composable
private fun StepItem(
    step: Int,
    isCompleted: Boolean,
    isCurrent: Boolean,
    isLast: Boolean
) {
    val circleColor by animateColorAsState(
        when {
            isCompleted -> Color(0xFF4CAF50)
            isCurrent -> Color(0xFF7C4DFF)
            else -> Color(0xFFE0E0E0)
        },
        animationSpec = tween(durationMillis = 600)
    )

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .background(circleColor, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = step.toString(),
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }

        if (!isLast) {
            val lineColor by animateColorAsState(
                when {
                    isCompleted -> Color(0xFF4CAF50)
                    else -> Color(0xFFE0E0E0)
                },
                animationSpec = tween(durationMillis = 600)
            )

            val lineWidth by animateDpAsState(
                if (isCompleted || isCurrent) 40.dp else 30.dp,
                animationSpec = tween(durationMillis = 500)
            )

            Box(
                modifier = Modifier
                    .height(3.dp)
                    .width(lineWidth)
                    .background(lineColor, RoundedCornerShape(50))
            )
        }
    }
}