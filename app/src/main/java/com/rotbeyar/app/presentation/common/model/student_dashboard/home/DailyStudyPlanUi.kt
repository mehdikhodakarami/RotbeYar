package com.rotbeyar.app.presentation.common.model.student_dashboard.home

import androidx.compose.ui.graphics.Color
import com.rotbeyar.app.ui.theme.PrimaryError
import com.rotbeyar.app.ui.theme.PrimaryGreen
import com.rotbeyar.app.ui.theme.PrimaryPurple
import com.rotbeyar.app.ui.theme.PrimaryWhite

enum class StudyPartStatusUi(val color: Color) {

    NOT_STARTED(PrimaryWhite),

    MISSED(PrimaryError),
    IN_PROGRESS(PrimaryPurple),

    DONE(PrimaryGreen);


}

data class DailyStudyPlanUi(
    val studyLessonList : List<StudyLessonUi> = emptyList()
)