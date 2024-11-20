plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.navigation.safeargs.kotlin) apply false
    alias(libs.plugins.ksp) apply false
}
[versions]
viewModelScope = "2.8.7"
navigationComponent = "2.8.3"

activity = "1.9.3"

koinBom = "4.0.0"
koin-annotations = "1.4.0"
kspVersion = "2.0.21-1.0.26"
logging-interceptor = "4.12.0"

[libraries]
viewmodel-scope = { group = "androidx.lifecycle", name = "lifecycle-viewmodel-ktx", version.ref = "viewModelScope" }
nav-fragment-ktx = { group = "androidx.navigation", name = "navigation-fragment-ktx", version.ref = "navigationComponent" }
nav-ui-ktx = { group = "androidx.navigation", name = "navigation-ui-ktx", version.ref = "navigationComponent" }

androidx-activity = { group = "androidx.activity", name = "activity", version.ref = "activity" }

koin-bom = { module = "io.insert-koin:koin-bom", version.ref = "koinBom" }
koin-android = { module = "io.insert-koin:koin-android"}
koin-annotations = { module = "io.insert-koin:koin-annotations", version.ref = "koin-annotations" }
koin-ksp = { group = "io.insert-koin", name = "koin-ksp-compiler", version.ref = "koin-annotations" }


[plugins]
android-application = { id = "com.android.application", version.ref = "agp" }
kotlin-android = { id = "org.jetbrains.kotlin.android", version.ref = "kotlin" }
navigation-safeargs-kotlin = { id = "androidx.navigation.safeargs.kotlin", version.ref = "navigationComponent" }
ksp = { id = "com.google.devtools.ksp", version.ref = "kspVersion" }
