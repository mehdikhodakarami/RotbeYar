package com.rotbeyar.app.domain.model.reservation

import com.rotbeyar.app.domain.model.GrgAppTime

enum class ReservationSlotStatus{
    AVAILABLE,
    RESERVED,
    SELECTED
}

data class ReservationSlot(
    val time : GrgAppTime ,
     val status : ReservationSlotStatus
)
