package com.rotbeyar.app.domain.model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import com.rotbeyar.app.R
import java.time.LocalDateTime
import java.time.LocalTime

data class Exam(
    val id : Long=1,
    val exam: ExamType = ExamType.GHALAMCHI,

    val examDateWithHours : LocalDateTime = LocalDateTime.of(
        2004,2,4,
        11,30,0)
    ,val daysLeft : Int = 3
)

enum class ExamType {
    GHALAMCHI,
    MAZ,
    GOZINEH_2,
    GAJ
}
