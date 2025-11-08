package com.rotbeyar.app.presentation.common.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SelectableField(
    modifier: Modifier = Modifier,
    label: String = "رشته تحصیلی",
    options: List<String> = listOf("تجربی","انسانی"),
    selectedOption: String? = null,
    onOptionSelected: (String) -> Unit = {}
) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .border(
                    width = 1.dp,
                    color = Color.Gray.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(20.dp)
                )
                .clickable { expanded = !expanded }
                .background(Color.White, )
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = selectedOption ?: "انتخاب کنید",
                    color = if (selectedOption == null) Color.Gray else Color.Black
                )

                Icon(
                    imageVector = if (expanded)
                        Icons.Default.KeyboardArrowUp
                    else
                        Icons.Default.KeyboardArrowDown,
                    contentDescription = null
                )
            }
        }

        AnimatedVisibility(visible = expanded) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF9F9F9), RoundedCornerShape(12.dp))
                    .border(
                        1.dp,
                        Color.Gray.copy(alpha = 0.3f),
                        RoundedCornerShape(20.dp)
                    )
                    .padding(8.dp)
            ) {
                options.forEach { option ->
                   Column {  Row(
                       modifier = Modifier
                           .fillMaxWidth()
                           .clip(RoundedCornerShape(8.dp))
                           .clickable {
                               onOptionSelected(option)
                               expanded = false
                           }
                           .background(
                               if (option == selectedOption)
                                   Color(0xFFD1C4E9)
                               else
                                   Color.Transparent
                           )
                           .padding(12.dp)
                   ) {
                       Text(
                           text = option,
                           color = if (option == selectedOption)
                               Color(0xFF512DA8)
                           else
                               Color.Black
                       )
                   }


                   if(option != options.last()){ HorizontalDivider(Modifier.fillMaxWidth().height(0.2.dp)) }
                   }
                }
            }
        }
    }
}