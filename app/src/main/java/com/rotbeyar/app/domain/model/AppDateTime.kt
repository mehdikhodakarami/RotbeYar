package com.rotbeyar.app.domain.model

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
    
    
    
    fun appLocalDate(): LocalDateTime {
        return LocalDateTime.of(year, month, day, hour, minute, second)
    }

}
fun LocalDateTime.grgToPersianDate(): PersianDate {
    val fixedZone = ZoneId.of("Asia/Tehran")
    val date = Date.from(this.atZone(fixedZone).toInstant())
    return PersianDate(date)
}
fun PersianDate.persianToGrg(): LocalDateTime{
    return  LocalDateTime.of(this.grgYear,
        this.grgMonth,
        this.grgDay,
        this.hour,
        this.minute,
        this.second)

}





