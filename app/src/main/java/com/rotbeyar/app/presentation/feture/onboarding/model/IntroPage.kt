package com.rotbeyar.app.presentation.feture.onboarding.model

import androidx.annotation.DrawableRes

data class IntroPage(
    @DrawableRes val imageResId: Int,
    val title: String,
    val description: String
)