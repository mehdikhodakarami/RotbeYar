package com.rotbeyar.app.presentation.onboarding.state

sealed class OnboardingAction {
    // --- Actions for the multi-page Intro Screen (IntroPagerScreen) ---
    // This action is sent when the user swipes or the pager programmatically scrolls.
    data class IntroPageChanged(val pageIndex: Int) : OnboardingAction()
    // This action is sent when the "Next" button is clicked on an intro page.
    object NextIntroPageClick : OnboardingAction()
    // Sent when the "Skip Intro" button is clicked (if you have one).
    object SkipIntroClick : OnboardingAction()


}