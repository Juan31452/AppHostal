plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.example.apphostal"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.apphostal"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
    buildToolsVersion = "34.0.0"
}

dependencies {
    // Dependencia para ActivityResultLauncher
    //implementation ("androidx.activity:activity-ktx:1.9.0")
    //implementation ("androidx.fragment:fragment:1.8.0")

    var fragment_version = "1.8.0"

    // Java language implementation
    implementation ("androidx.fragment:fragment:$fragment_version")

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)


}