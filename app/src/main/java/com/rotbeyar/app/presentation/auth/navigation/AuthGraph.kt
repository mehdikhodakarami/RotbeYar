package com.rotbeyar.app.presentation.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rotbeyar.app.presentation.auth.screens.CompleteInfoScreen
import com.rotbeyar.app.presentation.auth.screens.InsertPhoneNumberScreen
import com.rotbeyar.app.presentation.auth.screens.VerifyPhoneNumberScreen
import com.rotbeyar.app.presentation.common.navigation.AppRoute

fun NavGraphBuilder.authGraph(navController: NavController) {
    navigation<AppRoute.Auth>(
        startDestination = AuthRoute.InsertPhoneNumber
    ) {
        composable<AuthRoute.InsertPhoneNumber> {
            InsertPhoneNumberScreen()
        }
        composable <AuthRoute.VerifyPhoneNumber> {
            VerifyPhoneNumberScreen()
        }

        composable <AuthRoute.InsertNameLastName> {
            CompleteInfoScreen()
        }



    }
}