package com.rotbeyar.app.domain.model

import android.os.Build
import androidx.annotation.RequiresApi
import saman.zamani.persiandate.PersianDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date
data class AppGrgDateTime(
    val year: Int,
    val month: Int,
    val day: Int,
    val hour: Int = 0,
    val minute: Int = 0,
    val second: Int = 0
) {

    companion object{
        val persianWeekDays = listOf(
            "شنبه",
            "یکشنبه",
            "دوشنبه",
            "سه‌شنبه",
            "چهارشنبه",
            "پنجشنبه",
            "جمعه"
        )
    }
    
    
    
    @RequiresApi(Build.VERSION_CODES.O)
    fun appLocalDate(): LocalDateTime {
        return LocalDateTime.of(year, month, day, hour, minute, second)
    }

}
@RequiresApi(Build.VERSION_CODES.O)
fun LocalDateTime.grgToPersianDate(): PersianDate {
    val date = Date.from(this.atZone(ZoneId.systemDefault()).toInstant())
    return PersianDate(date)
}
@RequiresApi(Build.VERSION_CODES.O)
fun PersianDate.persianToGrg(): LocalDateTime{
    return  LocalDateTime.of(this.grgYear,
        this.grgMonth,
        this.grgDay,
        this.hour,
        this.minute,
        this.second)

}





