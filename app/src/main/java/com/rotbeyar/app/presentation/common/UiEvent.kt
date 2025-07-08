package com.rotbeyar.app.presentation.common

import android.content.Intent

sealed class UiEvent {


    data class NavigateTo(val route: String) : UiEvent()


    object NavigateBack : UiEvent()


    data class ShowSnackbar(
        val message: String,
        val actionLabel: String? = null
    ) : UiEvent()

    data class ShowToast(val message: String) : UiEvent()


    data class ShowDialog(
        val title: String,
        val message: String,
        val confirmButtonText: String? = null,
        val dismissButtonText: String? = null,
        val onConfirm: (() -> Unit)? = null, // Callback برای تایید عملیات دیالوگ
        val onDismiss: (() -> Unit)? = null // Callback برای لغو دیالوگ
    ) : UiEvent()



    data class OpenUrl(val url: String) : UiEvent()


    object HideKeyboard : UiEvent()


    object VibratePhone : UiEvent()

    data class RequestPermission(val permission: String, val requestCode: Int) : UiEvent()

    data class LaunchActivityResult(val intent: Intent, val requestCode: Int) : UiEvent()

    data class ShareContent(val content: String) : UiEvent()


    object SessionExpired : UiEvent()


    object AuthenticateUser : UiEvent()



    data class ScrollToItem(val index: Int) : UiEvent()


    data class ShowAnimation(val animationId: String) : UiEvent()

}