package com.rotbeyar.app.domain.model

// Represents the daily study plan of a user
enum class StudyPartStatus{

    NOT_STARTED,

    MISSED,
    IN_PROGRESS,

    DONE
}



data class DailyStudyPlan(
    val lessonsInDayPlan: List<StudyLesson> = emptyList()
) {
    val totalMinutes: Int
        get() = lessonsInDayPlan
            .filter { it.status == StudyPartStatus.DONE }
            .sumOf { it.durationSeconds }

    val totalSolvedTests: Int
        get() = lessonsInDayPlan
            .filter { it.status == StudyPartStatus.DONE }
            .sumOf { it.tests }

    fun getMissedParts(): List<StudyLesson> {
        return lessonsInDayPlan.filter { it.status == StudyPartStatus.MISSED }
    }

    fun getSessionsForLesson(lesson: Lesson): List<StudyLesson> {
        return lessonsInDayPlan.filter { it.lesson == lesson }
    }





}