package com.rotbeyar.app.domain.model

import com.rotbeyar.app.presentation.common.model.Lesson

data class DailyStudyPlan(
    val date: AppGrgDateTime,
    val sessions: List<StudyLesson> = emptyList()
) {
    val totalMinutes: Int
        get() = sessions.sumOf { it.durationMinutes }

    val totalSolvedTests: Int
        get() = sessions.sumOf { it.solvedTests }

    fun getUnfilledParts(): List<StudyPart> {
        val filled = sessions.map { it.part }
        return StudyPart.entries.filter { it !in filled }
    }
    fun getSessionsForLesson(lesson: Lesson): List<StudyLesson> {
        return sessions.filter { it.lesson == lesson }
    }
}