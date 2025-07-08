package com.rotbeyar.app.domain.model

import android.graphics.Color
import com.rotbeyar.app.presentation.common.model.Lesson

data class ToDoLessonItem(
    val status: ToDoStatus,

                          val lesson: Lesson,
                          val topic: Topic,
                          val isDone: Boolean,
                          val durationSeconds: Int,
                          val practiceCount: Int,
    val successColor : Color,
    val icon: RotbeYarIconModel

)
enum class ToDoStatus {
    NOT_STARTED,
    IN_PROGRESS,
    DONE
}