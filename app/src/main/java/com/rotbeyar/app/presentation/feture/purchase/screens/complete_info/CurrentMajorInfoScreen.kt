package com.rotbeyar.app.presentation.feture.purchase.screens.complete_info


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.rotbeyar.app.presentation.common.component.StandardBoxPage
import com.rotbeyar.app.presentation.feture.purchase.CompletePurchaseDetailAction
import com.rotbeyar.app.presentation.feture.purchase.CompletePurchaseDetailViewModel
import com.rotbeyar.app.presentation.feture.purchase.component.complete_info.CurrentMajorInfoContent
import com.rotbeyar.app.ui.theme.AppTheme

@Composable
fun CurrentMajorInfoScreen(modifier: Modifier = Modifier,
                           viewModel: CompletePurchaseDetailViewModel = hiltViewModel()){

    val state by viewModel.state.collectAsState()

    StandardBoxPage(modifier = modifier) {
        CurrentMajorInfoContent(
            currentMajor = state.currentMajor,
            educationLevel = state.educationLevelUi,
            majorForExam = state.currentMajorForExam,
            selectMajor = { viewModel.onAction(CompletePurchaseDetailAction.CurrentMajorClicked(it)) },
            selectEducationLevel = { viewModel.onAction(CompletePurchaseDetailAction.EducationLevelClicked(it)) },
            selectMajorForExam = { viewModel.onAction(CompletePurchaseDetailAction.CurrentMajorForExamClicked(it)) }

        )

    }


}

