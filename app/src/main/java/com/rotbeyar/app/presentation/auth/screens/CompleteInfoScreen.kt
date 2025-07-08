package com.rotbeyar.app.presentation.auth.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rotbeyar.app.presentation.auth.components.CompleteInfoScreenContent
import com.rotbeyar.app.presentation.common.component.StandardBoxPage
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.PrimaryBackgroundGradient

@Composable
fun CompleteInfoScreen(){
    StandardBoxPage(modifier = Modifier.fillMaxSize().background(brush = PrimaryBackgroundGradient)){
        CompleteInfoScreenContent(modifier = Modifier.padding(horizontal = 24.dp))
    }
}


@Preview(showBackground = true, locale = "fa")
@Composable
fun show2(){

    AppTheme {         CompleteInfoScreen()
    }
}