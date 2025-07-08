package com.rotbeyar.app.domain.model

import android.graphics.Color
import androidx.annotation.DrawableRes

data class RotbeYarIconModel(
    @DrawableRes val imageRes: Int ,
    val iconColor : Color,
    val iconBackGround : Color
)
