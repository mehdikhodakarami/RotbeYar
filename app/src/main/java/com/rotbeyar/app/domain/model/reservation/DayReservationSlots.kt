package com.rotbeyar.app.domain.model.reservation

import com.rotbeyar.app.domain.model.AppGrgDateTime
import com.rotbeyar.app.domain.model.GrgAppTime

data class DayReservationSlots(
    val date: AppGrgDateTime,
    val availableSlots: List<ReservationSlot>
)