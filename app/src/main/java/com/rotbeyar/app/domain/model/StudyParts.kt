package com.rotbeyar.app.domain.model
enum class StudyPart(val partNumber: Int, val startTime: String, val endTime: String) {
    PART_1(1, "08:00", "09:30"),
    PART_2(2, "09:30", "11:00"),
    PART_3(3, "11:00", "12:30"),
    PART_4(4, "12:30", "14:00"),
    PART_5(5, "14:00", "15:30"),
    PART_6(6, "15:30", "17:00"),
    PART_7(7, "17:00", "18:30"),
    PART_8(8, "18:30", "20:00"),
    PART_9(9, "20:00", "21:30"),
    PART_10(10, "21:30", "23:00");

    companion object {
        fun allParts(): List<StudyPart> = values().toList()
    }
}