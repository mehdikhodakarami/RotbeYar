package com.rotbeyar.app.domain.model

import com.google.type.DateTime
import saman.zamani.persiandate.PersianDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.util.Date


data class GrgAppTime(
    val hour: Int,
    val minute: Int,
    val second: Int = 0
) {

     fun GrgAppTime.grgToPersianTime(): PersianDate {

        val localDateTime = LocalDateTime.of(0, 0, 0, hour, minute, second)
        val fixedZone = ZoneId.of("Asia/Tehran")
        val date = Date.from(localDateTime.atZone(fixedZone).toInstant())
        return PersianDate(date)
    }





    fun appLocalTime(): LocalTime {
        return LocalTime.of(hour,minute,second)
    }







}