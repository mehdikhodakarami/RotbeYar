package com.rotbeyar.app.presentation.common.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun ClockComponent(seconds: Int =  3600,
                   fontSize: Int = 12,
                   fontWeight: FontWeight = FontWeight.Normal
                   ,fontColor: Color = MaterialTheme.colorScheme.onBackground
)

{
   val _hours = seconds / 3600
    val hours = _hours.toString().padStart(2, '0')
    val _minutes =(seconds - _hours * 3600) / 60
    val minutes = _minutes.toString().padStart(2, '0')

    val remainingSeconds = (seconds - (_hours * 3600 + _minutes * 60)).toString().padStart(2, '0')
    Text(text = "$hours:$minutes:$remainingSeconds",
        fontSize = fontSize.sp,
        fontWeight = fontWeight)


}
