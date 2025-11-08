package com.rotbeyar.app.presentation.feture.student_dashboard.home.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rotbeyar.app.presentation.common.component.StandardBoxPage
import com.rotbeyar.app.presentation.feture.student_dashboard.home.ViewModelHomeStudent
import com.rotbeyar.app.presentation.feture.student_dashboard.home.components.StudentHomeContent

import com.rotbeyar.app.ui.theme.AppTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: ViewModelHomeStudent = hiltViewModel(),

    contentPaddingValues: PaddingValues = PaddingValues(0.dp))


{
    val state by homeViewModel.homeUiState.collectAsState()

    StandardBoxPage(modifier =modifier.background(Color.White) ){
        StudentHomeContent(
            contentPaddingValues = contentPaddingValues,
            currentLesson = state.currentLesson,
            todayDevelop = state.todayDevelop,
            studyLessonList = state.dailyStudyPlan?.studyLessonList,
            nextExamsList = state.nextExamsList,
            shortTimeTarget = state.shortTimeTarget
        )
    }


}
