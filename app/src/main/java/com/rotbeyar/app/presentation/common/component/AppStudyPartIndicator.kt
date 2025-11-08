package com.rotbeyar.app.presentation.common.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.StudyPartStatusUi

@Composable
fun AppStudyPartIndicator(

    modifier: Modifier = Modifier
,
        status: StudyPartStatusUi
) {
    Canvas(modifier = modifier.size(18.dp)) {
        val strokeWidth = size.minDimension * 0.1f
        val radius = size.minDimension / 2

        when (status) {
            StudyPartStatusUi.DONE -> {
                // outer circle
                drawCircle(
                    color = Color.Green.copy(alpha = 0.2f),
                    radius = radius
                )
                drawLine(
                    color = Color.Green,
                    start = Offset(x = radius * 0.5f, y = radius),
                    end = Offset(x = radius * 0.8f, y = radius * 1.3f),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )
                drawLine(
                    color = Color.Green,
                    start = Offset(x = radius * 0.8f, y = radius * 1.3f),
                    end = Offset(x = radius * 1.4f, y = radius * 0.6f),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )
            }

            StudyPartStatusUi.IN_PROGRESS -> {
                drawCircle(
                    color = status.color,
                    radius = radius
                )

                drawCircle(
                    color = Color.White,
                    radius = radius * 0.4f
                )
            }

            StudyPartStatusUi.MISSED -> {
                // red cross
                drawCircle(
                    color = Color.Red.copy(alpha = 0.1f),
                    radius = radius
                )
                drawLine(
                    color = Color.Red,
                    start = Offset(radius * 0.6f, radius * 0.6f),
                    end = Offset(radius * 1.4f, radius * 1.4f),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )
                drawLine(
                    color = Color.Red,
                    start = Offset(radius * 1.4f, radius * 0.6f),
                    end = Offset(radius * 0.6f, radius * 1.4f),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )
            }

            StudyPartStatusUi.NOT_STARTED -> {
                // hollow gray circle
                drawCircle(
                    color = Color.Gray,
                    radius = radius * 0.8f,
                    style = Stroke(width = strokeWidth)
                )
            }


        }
    }
}