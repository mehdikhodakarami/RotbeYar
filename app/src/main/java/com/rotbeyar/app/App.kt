package com.rotbeyar.app

import android.app.Application
import android.content.res.Configuration
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp
import java.util.Locale

@HiltAndroidApp
class App: Application() {
    private fun setAppLocale(languageCode: String) {
        val locale = Locale(languageCode, "IR")
        Locale.setDefault(locale)

        val config = Configuration()
        config.setLocale(locale)
        config.setLayoutDirection(locale)

        resources.updateConfiguration(config, resources.displayMetrics)
    }



    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        setAppLocale("fa") // Set default locale to Persian (fa)
        // You can also set it based on user preference or system settings
    }

}