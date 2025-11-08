package com.rotbeyar.app.presentation.feture.splash.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rotbeyar.app.presentation.common.component.StandardBoxPage
import com.rotbeyar.app.presentation.feture.splash.components.SplashScreenContent

@Composable
fun SplashScreen(
    descriptionText : String = "در حال بارگذاری"
)
{
    StandardBoxPage {

        SplashScreenContent(text = descriptionText, modifier = Modifier)
    }

}