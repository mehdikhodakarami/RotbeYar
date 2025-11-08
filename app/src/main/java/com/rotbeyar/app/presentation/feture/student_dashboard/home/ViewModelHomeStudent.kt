package com.rotbeyar.app.presentation.feture.student_dashboard.home

import androidx.lifecycle.ViewModel
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.DailyStudyPlanUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.ExamUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.ShortTimeTargetUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.StudyLessonUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.TodayDevelopUi
import com.rotbeyar.app.presentation.feture.student_dashboard.home.action.HomeStudentAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class HomeStudentState(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val exam: ExamUi? = null,
    val shortTimeTarget: ShortTimeTargetUi?= null,
    val todayDevelop: TodayDevelopUi?= null,
   val currentLesson : StudyLessonUi?= null,
    val nextExamsList : List<ExamUi>?= null,
    val dailyStudyPlan: DailyStudyPlanUi?= null,
    )


@HiltViewModel
class ViewModelHomeStudent @Inject constructor(): ViewModel()

{
   private val _homeState = MutableStateFlow<HomeStudentState>(HomeStudentState())
    val homeUiState = _homeState.asStateFlow()

    fun onAction(action: HomeStudentAction){
        when(action){
            is HomeStudentAction.RefreshData -> {

            }
            is HomeStudentAction.StartStudyCurrentLesson -> {

            }
            is HomeStudentAction.ViewTodayDevelopmentDetails -> {

            }
            is HomeStudentAction.ViewAllNextExams -> {

            }
            is HomeStudentAction.RecordExamResult -> {

            }
            is HomeStudentAction.ViewExamTopics -> {

            }
            is HomeStudentAction.IncreaseTestLessonStudy -> {

            }
            is HomeStudentAction.DecreaseTestLessonStudy -> {

            }
            is HomeStudentAction.CheckLessonStudy -> {

            }
        }
    }





}