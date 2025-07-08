package com.rotbeyar.app.presentation.common.component


import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import com.rotbeyar.app.ui.theme.VazirFamily

@Composable
fun RotbeYarText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.bodyMedium.fontSize,
    fontWeight: androidx.compose.ui.text.font.FontWeight? = null,
    fontFamily: FontFamily = VazirFamily,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = TextStyle.Default
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        maxLines = maxLines,
        overflow = overflow,
        style = style
    )
}