package com.rotbeyar.app.presentation.feture.auth.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

import com.rotbeyar.app.presentation.common.component.StandardBoxPage
import com.rotbeyar.app.presentation.feture.auth.AuthAction
import com.rotbeyar.app.presentation.feture.auth.AuthViewModel
import com.rotbeyar.app.presentation.feture.auth.components.VerifyScreenContent
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.PrimaryBackgroundGradient

@Composable
fun VerifyPhoneNumberScreen(
    viewModel: AuthViewModel = hiltViewModel(),
){

//    val context = androidx.compose.ui.platform.LocalContext.current

    val state by viewModel.uiState.collectAsState()
    StandardBoxPage(modifier = Modifier
        .fillMaxSize()
        .background(brush = PrimaryBackgroundGradient)){

    VerifyScreenContent(
        codeInsertSuccess = state.isLogined,
        codeInput = state.code,
        isLoading = state.isLoading,
        errorMessage = state.errorMessage,
        onCodeInputChange = { code ->

            viewModel.onAction(AuthAction.CodeChanged(code))
        } , onVerifyCodeClick =
            { viewModel.onAction(AuthAction.VerifyCode) }

        )}}
