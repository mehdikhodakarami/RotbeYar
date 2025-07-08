import org.gradle.kotlin.dsl.implementation

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.gms.google-services")
    id("com.google.devtools.ksp")
    id ("kotlinx-serialization")


    id("com.google.dagger.hilt.android")
}


android {
    namespace = "com.rotbeyar.app"
    compileSdk = 35

    defaultConfig {


        applicationId = "com.rotbeyar.app"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = listOf("-XXLanguage:+PropertyParamAnnotationDefaultTargetMode")
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }

    buildToolsVersion = "36.0.0"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.datastore.core.android)
    implementation(libs.androidx.room.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    // Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:33.3.0"))


    // TODO: Add the dependencies for Firebase products you want to use
    // When using the BoM, don't specify versions in Firebase dependencies
    implementation("com.google.firebase:firebase-analytics")


    // Add the dependencies for any other desired Firebase products
    // https://firebase.google.com/docs/android/setup#available-libraries

    implementation("androidx.constraintlayout:constraintlayout-compose:1.1.1") // یا آخرین نسخه پایدار

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation("io.reactivex.rxjava3:rxandroid:3.0.2")
    implementation("io.reactivex.rxjava3:rxjava:3.1.5")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    // Converter-Gson: مبدل برای تبدیل JSON به آبجکت‌های کاتلین/جاوا و برعکس
    // Gson یک کتابخانه محبوب برای کار با JSON است که Square (توسعه‌دهنده Retrofit)
    // یک آداپتور برای آن ساخته است.
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // OkHttp Logging Interceptor: ابزار بسیار مفید برای دیباگ کردن درخواست‌های شبکه.
    // این Interceptor تمام جزئیات درخواست‌ها و پاسخ‌ها را در Logcat نمایش می‌دهد.
    // OkHttp کتابخانه‌ای است که Retrofit زیر لایه از آن برای انجام واقعی درخواست‌ها استفاده می‌کند.
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0") // یا آخرین نسخه

    // Coroutines (Kotlinx Coroutines): برای مدیریت عملیات‌های غیرهم‌زمان (شبکه) به صورت تمیزتر و آسان‌تر.
    // قویاً توصیه می‌شود که برای شبکه‌سازی در کاتلین از Coroutines استفاده کنید.
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3") // یا آخرین نسخه
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3") // برای استفاده در اندروید
//    implementation("com.google.dagger:hilt-android:2.56.2")
//    // --- این خط رو اضافه کنید (یا اگر دارید، اصلاحش کنید) ---
//    ksp("com.google.dagger:hilt-android-compiler:2.51.1") // کامپایلر Hilt با KSP
//
//    // اگر از Hilt با ViewModel یا Jetpack components استفاده می‌کنید:
//    ksp("androidx.hilt:hilt-compiler:1.2.0") //
    implementation("com.google.dagger:hilt-android:2.56.2")
    ksp("com.google.dagger:hilt-android-compiler:2.56.2")
//    ksp("androidx.room:room-compiler:2.5.0")

    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    implementation("com.google.accompanist:accompanist-navigation-animation:0.34.0")
    implementation("com.squareup.retrofit2:retrofit:3.0.0")
    implementation("com.squareup.retrofit2:converter-gson:3.0.0")
    implementation("com.google.firebase:firebase-firestore-ktx")
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.accompanist:accompanist-pager:0.36.0")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.36.0")
    implementation("androidx.compose.foundation:foundation:1.4.3")
//    implementation("com.github.samanzamani.persiandate:PersianDate:0.8")
    val navVersion = "2.9.3"

    implementation("androidx.navigation:navigation-compose:$navVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")

//    implementation("com.github.sham-h93:persian-dtpicker:1.1.1")
    implementation("com.github.samanzamani:PersianDate:1.7.1")

//    implementation(libs.vico.compose)
//    implementation(libs.vico.compose.m2)
//    implementation(libs.vico.compose.m3)
//    implementation(libs.vico.multiplatform)
//    implementation(libs.vico.views)

    implementation("io.github.dautovicharis:charts:2.0.0")

//


}

