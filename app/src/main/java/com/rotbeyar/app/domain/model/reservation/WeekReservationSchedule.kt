package com.rotbeyar.app.domain.model.reservation

import com.rotbeyar.app.domain.model.AppGrgDateTime
import com.rotbeyar.app.domain.model.Week

data class WeekReservationSchedule(

    val week: Week,
    val day: DayReservationSlots
)
