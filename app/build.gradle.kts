plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.androidx.navigation.safeargs)
    alias(libs.plugins.ksp)

}

android {
    namespace = "com.example.superheroes24"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.superheroes24"
        minSdk = 26
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation (libs.retrofit)
    implementation(libs.gson.serializer)
    implementation(libs.converter.gson)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.logging.interceptor)
    implementation(libs.glide)
    implementation(libs.androidx.cardview)
    implementation(libs.coil)
    implementation(libs.coil)
    implementation(libs.androidx.navigation.fragment)
    implementation (libs.androidx.fragment)
    implementation (libs.retrofit)
    implementation (libs.retrofit2.converter.gson)
    implementation(libs.play.services.dtdi)

    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.koin.android)
    implementation(libs.koin.annotations)

    ksp(libs.koin.ksp)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

}
ksp {
    arg("KOIN_CONFIG_CHECK","true")
}