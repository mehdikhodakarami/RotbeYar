package com.rotbeyar.app.presentation.feture.purchase.screens.complete_info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rotbeyar.app.presentation.common.component.StandardBoxPage
import com.rotbeyar.app.presentation.common.model.StudyMethodUi
import com.rotbeyar.app.presentation.feture.purchase.CompletePurchaseDetailAction
import com.rotbeyar.app.presentation.feture.purchase.CompletePurchaseDetailViewModel
import com.rotbeyar.app.presentation.feture.purchase.component.complete_info.ExamInfoContent
import com.rotbeyar.app.presentation.feture.purchase.component.complete_info.SchoolInfoContent
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.PrimaryBackgroundGradient

@Composable
fun SchoolInfoScreen(modifier: Modifier = Modifier,
                     viewModel: CompletePurchaseDetailViewModel = hiltViewModel()
){
val state by viewModel.state.collectAsState()
    StandardBoxPage(modifier = modifier) {
        SchoolInfoContent(modifier = Modifier.padding(16.dp),
            studyMethodUi = state.studyMethod?: StudyMethodUi.SELF_STUDY,
            selectStudyMethod = {viewModel.onAction(
                CompletePurchaseDetailAction.StudyMethodClicked(it))}
            )

    }


}

