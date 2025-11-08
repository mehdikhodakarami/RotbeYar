package com.rotbeyar.app.presentation.feture.auth.navigation

import android.widget.Toast
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

import com.rotbeyar.app.presentation.common.navigation.AppRoute
import com.rotbeyar.app.presentation.feture.auth.AuthViewModel
import com.rotbeyar.app.presentation.feture.auth.events.AuthEvent
import com.rotbeyar.app.presentation.feture.auth.screens.CompleteInfoScreen
import com.rotbeyar.app.presentation.feture.auth.screens.InsertPhoneNumberScreen
import com.rotbeyar.app.presentation.feture.auth.screens.VerifyPhoneNumberScreen

fun NavGraphBuilder.authGraph(
    shouldCompleteProfile : Boolean = false,
    navController: NavController,
    onFinished: () -> Unit = {}
) {

    navigation<AppRoute.Auth>(

        startDestination = if(shouldCompleteProfile) AuthRoute.InsertNameLastName else AuthRoute.InsertPhoneNumber
    )

    {

        composable<AuthRoute.InsertPhoneNumber> {

            entry ->
            val context = LocalContext.current
            val parentEntry = remember(entry) {
                navController.getBackStackEntry(AppRoute.Auth)
            }
            val viewModel: AuthViewModel = hiltViewModel(parentEntry)
            LaunchedEffect(Unit){
                viewModel.uiEvent.collect {
                    when(it){
                        AuthEvent.NavigateToVerifyCode -> navController.navigate(AuthRoute.VerifyPhoneNumber)
                        is AuthEvent.ShowSnackBar -> Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                        AuthEvent.FinishedLogin -> TODO()
                        AuthEvent.NavigateToCompleteProfile -> TODO()
                    }
                }
            }
            InsertPhoneNumberScreen(viewModel = viewModel)
        }

        composable<AuthRoute.VerifyPhoneNumber> { entry ->
            val parentEntry = remember(entry) {
                navController.getBackStackEntry(AppRoute.Auth)
            }
            val context = LocalContext.current
            val viewModel: AuthViewModel = hiltViewModel(parentEntry)
            LaunchedEffect(Unit){
                 viewModel.uiEvent.collect {
                     when(it){

                         AuthEvent.NavigateToVerifyCode -> TODO()
                         is AuthEvent.ShowSnackBar -> Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                         AuthEvent.FinishedLogin ->onFinished()
                         AuthEvent.NavigateToCompleteProfile -> navController.navigate(AuthRoute.InsertNameLastName){
                             popUpTo(AuthRoute.InsertPhoneNumber){
                                 inclusive = true
                             }
                         }
                     }
                 }
            }
            VerifyPhoneNumberScreen(
                viewModel = viewModel,
            )
        }

        composable<AuthRoute.InsertNameLastName> { entry ->

            val parentEntry = remember(entry) {
                navController.getBackStackEntry(AppRoute.Auth)
            }

            val authViewModel: AuthViewModel = hiltViewModel(parentEntry)
LaunchedEffect(Unit) {
    authViewModel.uiEvent.collect {event->
        when(event){
            AuthEvent.FinishedLogin -> onFinished()
            AuthEvent.NavigateToCompleteProfile -> TODO()
            AuthEvent.NavigateToVerifyCode -> TODO()
            is AuthEvent.ShowSnackBar -> {}
        }
    }

}


            CompleteInfoScreen(
                authViewModel = authViewModel
            )
        }
    }
}