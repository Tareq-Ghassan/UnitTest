plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.realm)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.dagger.hilt)
}

android {
    namespace = "com.oppensooq.artbook"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.oppensooq.artbook"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
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
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.coil.compose)


    // dagger hilt Android
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    // Coroutines
    implementation(libs.kotlinx.coroutines.android)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // ViewModel
    implementation (libs.androidx.lifecycle.viewmodel)

    // LiveData
    implementation (libs.androidx.lifecycle.livedata)

    //Realm DB
    implementation(libs.library.base)

    // Navigation
    implementation(libs.androidx.navigation.compose)




    // TestImplementations
    implementation (libs.androidx.core)
    testImplementation (libs.junit)
    testImplementation (libs.hamcrest.all)
    testImplementation (libs.androidx.core.testing)
    testImplementation (libs.robolectric)
    testImplementation (libs.kotlinx.coroutines.test)
    testImplementation (libs.truth)
    testImplementation (libs.mockito.core)

    // Android Test Implementations
    androidTestImplementation (libs.junit)
    //androidTestImplementation ("com.linkedin.dexmaker:dexmaker-mockito:2.12.1")
    androidTestImplementation (libs.mockito.android)
    androidTestImplementation (libs.kotlinx.coroutines.test.v164)
    androidTestImplementation (libs.androidx.core.testing)
    androidTestImplementation (libs.truth)
    androidTestImplementation (libs.androidx.espresso.core.v351)
    androidTestImplementation (libs.mockito.core.v470)
    androidTestImplementation (libs.hilt.android.testing)
    kaptAndroidTest (libs.hilt.android.compiler.v248)
    debugImplementation (libs.androidx.fragment.testing)
}

kapt {
    correctErrorTypes = true
}