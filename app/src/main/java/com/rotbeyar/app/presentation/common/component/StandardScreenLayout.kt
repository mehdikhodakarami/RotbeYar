package com.rotbeyar.app.presentation.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.rotbeyar.app.ui.theme.PrimaryBackgroundGradient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StandardScreenLayout(
    modifier: Modifier = Modifier,
    snackBarHostState: SnackbarHostState? = null,
    topBar: @Composable (() -> Unit)? = null,
    bottomBar: @Composable (() -> Unit)? = null,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = modifier,
        snackbarHost = {
            if (snackBarHostState != null) {
                SnackbarHost(snackBarHostState)
            }
        },
        topBar = { topBar?.invoke() },
        bottomBar = { bottomBar?.invoke() }
    ) { paddingValues ->

        content(paddingValues)
    }
}



@Composable
fun StandardBoxPage(
    modifier: Modifier = Modifier.background(brush = PrimaryBackgroundGradient),
    content: @Composable BoxScope.() -> Unit
)


{

    Box(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {

        content()


    }

}



