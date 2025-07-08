package com.rotbeyar.app.utils

import android.os.Build
import androidx.annotation.RequiresApi
import saman.zamani.persiandate.PersianDate
import saman.zamani.persiandate.PersianDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date

object DateConverter {

    @RequiresApi(Build.VERSION_CODES.O)
    fun toShamsi(
        date: LocalDate,
        pattern: String = "j F Y",
        farsiNumbers: Boolean = true
    ): String {
        val utilDate: Date = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant())
        val persianDate = PersianDate(utilDate)

        val numberChar = if (farsiNumbers)
            PersianDateFormat.PersianDateNumberCharacter.FARSI
        else
            PersianDateFormat.PersianDateNumberCharacter.ENGLISH

        val formatter = PersianDateFormat(pattern, numberChar)
        return formatter.format(persianDate)
    }
}