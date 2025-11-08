package com.rotbeyar.app.presentation.common.model

import androidx.annotation.StringRes
import com.rotbeyar.app.R

enum class StudyMethodUi(@StringRes title : Int) {
    SCHOOL(R.string.study_with_school),
    ONLINE_SCHOOL(R.string.online_school),
    SELF_STUDY(R.string.self_study)
}