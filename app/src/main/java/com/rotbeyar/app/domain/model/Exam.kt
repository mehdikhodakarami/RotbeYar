package com.rotbeyar.app.domain.model

import androidx.annotation.StringRes
import com.rotbeyar.app.R

data class Exam(
    val id: Int = 1,
    @StringRes val title : Int= R.string.exam_ghalamchi,
    val examDates : List<AppGrgDateTime> =emptyList()
)
