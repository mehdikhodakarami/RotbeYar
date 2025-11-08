package com.rotbeyar.app.presentation.feture.auth.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rotbeyar.app.presentation.common.component.StandardBoxPage
import com.rotbeyar.app.presentation.feture.auth.AuthAction
import com.rotbeyar.app.presentation.feture.auth.AuthViewModel
import com.rotbeyar.app.presentation.feture.auth.components.LoginScreenContent
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.PrimaryBackgroundGradient

@Composable
fun InsertPhoneNumberScreen(
    viewModel: AuthViewModel = hiltViewModel())

{

    val state by viewModel.uiState.collectAsState()
    StandardBoxPage(modifier = Modifier.fillMaxSize().
    background(brush = PrimaryBackgroundGradient)){
        LoginScreenContent(
            loading = state.isLoading,
        isError = (state.errorMessage?.isNotEmpty() == true),
            errorMessage = state.errorMessage,
            phoneNumber = state.phoneNumber,
            onSendButton = { viewModel.onAction(AuthAction.CheckUser) },

            onPhoneChange = { if (it.length<=11){viewModel.onAction(
                AuthAction.PhoneChanged(it))} },

            modifier = Modifier.padding(horizontal = 24.dp).align(Alignment.Center))

    }
}

