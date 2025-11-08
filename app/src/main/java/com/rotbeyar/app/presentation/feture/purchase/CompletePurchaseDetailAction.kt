package com.rotbeyar.app.presentation.feture.purchase

import com.rotbeyar.app.domain.model.ExamType
import com.rotbeyar.app.domain.model.StudyMethod
import com.rotbeyar.app.domain.model.StudyPart
import com.rotbeyar.app.domain.model.user.EducationMajor
import com.rotbeyar.app.presentation.common.model.EducationLevelUi
import com.rotbeyar.app.presentation.common.model.EducationMajorUi
import com.rotbeyar.app.presentation.common.model.StudyMethodUi

sealed class CompletePurchaseDetailAction {

    data class ExamTypeClicked(val examType: ExamType) : CompletePurchaseDetailAction()
    data class StudyMethodClicked(val studyMethod: StudyMethodUi) : CompletePurchaseDetailAction()
    data class FatherNameChanged(val name:String) : CompletePurchaseDetailAction()
    data class MotherNameChanged(val name:String) : CompletePurchaseDetailAction()
    data class FatherPhoneNumberChanged(val phone:String) : CompletePurchaseDetailAction()
    data class MotherPhoneNumberChanged(val phone:String) : CompletePurchaseDetailAction()
    data class CurrentMajorClicked(val major: EducationMajorUi) : CompletePurchaseDetailAction()
    data class CurrentMajorForExamClicked(val major: EducationMajorUi) : CompletePurchaseDetailAction()
    data class EducationLevelClicked(val educationLevel: EducationLevelUi) : CompletePurchaseDetailAction()
    data class BusyTimeInWeekClicked(val busyTimeInWeek: Pair<Int, StudyPart>) : CompletePurchaseDetailAction()

    object CompleteUpdateInfo : CompletePurchaseDetailAction()











}