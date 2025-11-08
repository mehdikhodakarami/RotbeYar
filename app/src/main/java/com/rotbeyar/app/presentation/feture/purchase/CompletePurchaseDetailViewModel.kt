package com.rotbeyar.app.presentation.feture.purchase

import androidx.lifecycle.ViewModel
import com.rotbeyar.app.domain.model.ExamType
import com.rotbeyar.app.domain.model.StudyPart
import com.rotbeyar.app.presentation.common.model.EducationLevelUi
import com.rotbeyar.app.presentation.common.model.EducationMajorUi
import com.rotbeyar.app.presentation.common.model.StudyMethodUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

data class CompletePurchaseDetailState(
    val examTypes: Set<ExamType> = emptySet(),
    val studyMethod: StudyMethodUi? = null,
    val fatherFirstName : String ="",
    val motherFirstName :String="",
    val fatherPhoneNumber:String="",
    val motherPhoneNumber : String="",
    val currentMajor : EducationMajorUi? = null,
    val educationLevelUi: EducationLevelUi? = null,
    val currentMajorForExam : EducationMajorUi? = null,
    val busyTimesInWeek : Map<Int, Set<StudyPart>> = emptyMap()
)
@HiltViewModel
class CompletePurchaseDetailViewModel @Inject constructor() : ViewModel() {

    private val _state  = MutableStateFlow<CompletePurchaseDetailState>(CompletePurchaseDetailState())
    val state = _state.asStateFlow()


    fun onAction(action : CompletePurchaseDetailAction){
        when(action){
            is CompletePurchaseDetailAction.BusyTimeInWeekClicked -> changeBusyTimeInWeek(action.busyTimeInWeek)

            CompletePurchaseDetailAction.CompleteUpdateInfo -> TODO()
            is CompletePurchaseDetailAction.CurrentMajorClicked -> changeCurrentMajor(action.major)
            is CompletePurchaseDetailAction.CurrentMajorForExamClicked -> changeCurrentMajorForExam(action.major)
            is CompletePurchaseDetailAction.EducationLevelClicked -> changeEducationLevel(action.educationLevel)
            is CompletePurchaseDetailAction.ExamTypeClicked -> addExamType(action.examType)
            is CompletePurchaseDetailAction.FatherNameChanged -> changeFatherName(action.name)
            is CompletePurchaseDetailAction.FatherPhoneNumberChanged -> changeFatherPhoneNumber(action.phone)
            is CompletePurchaseDetailAction.MotherNameChanged -> changeMotherName(action.name)
            is CompletePurchaseDetailAction.MotherPhoneNumberChanged -> changeMotherPhoneNumber(action.phone)
            is CompletePurchaseDetailAction.StudyMethodClicked -> changeStudyMethod(action.studyMethod)
        }
    }

    private fun addExamType(examType: ExamType){
      _state.update {it.copy(examTypes = it.examTypes + examType) }
    }
    private fun changeStudyMethod(studyMethod: StudyMethodUi){
        _state.update { it.copy(studyMethod = studyMethod) }
    }
    private fun changeFatherName(name:String){
        _state.update { it.copy(fatherFirstName = name) }
    }
   private fun changeMotherName(name:String){
        _state.update { it.copy(motherFirstName = name) }
    }
    private fun changeFatherPhoneNumber(phone:String){
        _state.update { it.copy(fatherPhoneNumber = phone) }
    }
    private fun changeMotherPhoneNumber(phone:String){
        _state.update { it.copy(motherPhoneNumber = phone) }
    }
    private fun changeCurrentMajor(major: EducationMajorUi){
        _state.update { it.copy(currentMajor = major) }
    }
    private fun changeCurrentMajorForExam(major: EducationMajorUi) {
        _state.update {
            it.copy(currentMajorForExam = major)
        }

    }
    private fun changeEducationLevel(educationLevelUi: EducationLevelUi){
        _state.update { it.copy(educationLevelUi = educationLevelUi) }
    }
    private fun changeBusyTimeInWeek(busyTimeInWeek: Pair<Int, StudyPart>) {
        val (day, part) = busyTimeInWeek
        _state.update { currentState ->
            val currentMap = currentState.busyTimesInWeek.toMutableMap()

            val currentSet = currentMap[day]?.toMutableSet() ?: mutableSetOf()

            if (currentSet.contains(part)) {
                currentSet.remove(part)
            } else {
                currentSet.add(part)
            }

            currentMap[day] = currentSet

            currentState.copy(busyTimesInWeek = currentMap)
        }
    }




}
