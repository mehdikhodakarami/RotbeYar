package com.rotbeyar.app.presentation.feture.auth.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

import com.rotbeyar.app.presentation.common.component.StandardBoxPage
import com.rotbeyar.app.presentation.feture.auth.AuthAction
import com.rotbeyar.app.presentation.feture.auth.AuthViewModel
import com.rotbeyar.app.presentation.feture.auth.components.CompleteInfoScreenContent
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.PrimaryBackgroundGradient

@Composable
fun CompleteInfoScreen(

authViewModel : AuthViewModel = hiltViewModel()){
val authUiState by authViewModel.uiState.collectAsState()


    StandardBoxPage(modifier = Modifier.fillMaxSize().background(brush = PrimaryBackgroundGradient)){
        CompleteInfoScreenContent(
            isLoading = authUiState.isLoading,
            errorMessage = authUiState.errorMessage?:"",
name = authUiState.firstName,
            lastName = authUiState.lastName,
onNameChanged = {authViewModel.onAction(AuthAction.NameChanged(it))},
            onLastNameChanged = {authViewModel.onAction(AuthAction.LastNameChanged(it))},
            onCompleteButtonClick = { authViewModel.onAction(AuthAction.CompleteProfile) },
            modifier = Modifier.padding(horizontal = 24.dp))
    }
}


