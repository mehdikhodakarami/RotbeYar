package com.rotbeyar.app.presentation.common.component


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rotbeyar.app.ui.theme.AppStyle
import com.rotbeyar.app.ui.theme.VazirFamily
@Composable
fun RotbeYarButton(
    fontWeight: FontWeight = FontWeight.Medium,
    fontSize: TextUnit = 14.sp,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loading: Boolean = false,
    icon: ImageVector? = null,
    iconDescription: String? = null,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    gradient: Brush? = null,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary,
    shape: Shape = RoundedCornerShape(AppStyle.CornerSmall),
    height: Dp = 52.dp,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(0.dp)
) {
    if (gradient != null) {
        Box(
            modifier = modifier

                .background(brush = gradient, shape = shape)
                .clip(shape)
        ) {
            Button(
                onClick = onClick,
                enabled = enabled && !loading,
                shape = shape,
                elevation = elevation,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = contentColor,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = contentColor.copy(alpha = 0.6f)
                ),
                modifier = modifier
                    .height(height)
            ) {
                ButtonContent(
                    loading = loading,
                    icon = icon,
                    iconDescription = iconDescription,
                    text = text,
                    fontWeight = fontWeight,
                    fontSize = fontSize,
                    contentColor = contentColor
                )
            }
        }
    } else {
        Button(
            onClick = onClick,

            enabled = enabled && !loading,
            modifier = modifier.height(height),
            shape = shape,
            elevation = elevation,
            colors = ButtonDefaults.buttonColors(
                containerColor = backgroundColor,
                contentColor = contentColor,
                disabledContainerColor = backgroundColor.copy(alpha = 0.4f),
                disabledContentColor = contentColor.copy(alpha = 0.6f)
            )
        ) {
            ButtonContent(
                loading = loading,
                icon = icon,
                iconDescription = iconDescription,
                text = text,
                fontWeight = fontWeight,
                fontSize = fontSize,
                contentColor = contentColor
            )
        }
    }
}

@Composable
private fun ButtonContent(
    loading: Boolean,
    icon: ImageVector?,
    iconDescription: String?,
    text: String,
    fontWeight: FontWeight,
    fontSize: TextUnit,
    contentColor: Color
) {
    if (loading) {
        CircularProgressIndicator(
            color = contentColor,
            strokeWidth = 2.dp,
            modifier = Modifier.size(20.dp)
        )
    } else {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = iconDescription,
                modifier = Modifier
                    .size(20.dp)
                    .padding(end = 8.dp)
            )
        }
        Text(
            text = text,
            fontWeight = fontWeight,
            fontSize = fontSize,
            color = contentColor,
            fontFamily = VazirFamily
        )
    }
}