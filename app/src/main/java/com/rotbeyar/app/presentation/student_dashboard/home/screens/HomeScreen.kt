package com.rotbeyar.app.presentation.student_dashboard.home.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rotbeyar.app.presentation.student_dashboard.home.components.StudentHomeContent
import com.rotbeyar.app.ui.theme.AppTheme

@Composable
fun HomeScreen(contentPaddingValues: PaddingValues = PaddingValues(0.dp)){

StudentHomeContent(contentPaddingValues = contentPaddingValues)

}
@Composable
@Preview(showBackground = true, locale = "fa")
fun Preview(){
    AppTheme{
        HomeScreen()

    }
}