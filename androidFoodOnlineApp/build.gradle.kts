
plugins {
    id("com.android.application")
    kotlin("android")
    kotlin(KotlinPlugins.kapt)
    id(Plugins.hilt)
    kotlin(KotlinPlugins.serialization) version  Kotlin.version

}

android {
    compileSdk = Application.compileSdk
    defaultConfig {
        applicationId = "com.example.foodonline.android"
        minSdk = Application.minSdk
        targetSdk = Application.targetSdk
        versionCode = Application.versionCode
        versionName = Application.versionName
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
    compileOptions{
        sourceCompatibility =  org.gradle.api.JavaVersion.VERSION_11
        targetCompatibility = org.gradle.api.JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"

    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeVersion
    }


}

dependencies {
    implementation(project(":shared"))
    implementation(Compose.androidCore)
//    implementation("com.google.android.material:material:1.6.1")
//    implementation("androidx.appcompat:appcompat:1.5.0")
//    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(Accompanist.coil)

    implementation(AndroidX.appCompat)

    implementation(Compose.runtime)
    implementation(Compose.runtimeLiveData)
    implementation(Compose.ui)
    implementation(Compose.material)
    implementation(Compose.uiTooling)
    implementation(Compose.foundation)
    implementation(Compose.compiler)
    implementation(Compose.constraintLayout)
    implementation(Compose.activity)
    implementation(Compose.navigation)

    implementation(Google.material)

    implementation(Hilt.hiltAndroid)
    implementation(Hilt.hiltComposeNavigation)
    kapt(Hilt.hiltCompiler)

    implementation(Kotlinx.datetime)
    implementation(Ktor.android)

    debugImplementation(SquareUp.leakCanary)

    //implementation(Lifecycles.viewModel)
    //implementation(Lifecycles.viewModelCompose)
//    implementation(Lifecycles.liveData)
//    implementation(Lifecycles.runtime)
//    implementation(Lifecycles.saveState)
//    kapt(Lifecycles.annotationProcessor)
//    implementation(Lifecycles.lifecycleCompiler)
//    implementation(Lifecycles.lifecycleOwner)
//    implementation(Lifecycles.processlifecycleOwner)
//    implementation(Lifecycles.reactiveStreamsLiveData)
//    testImplementation(Lifecycles.testLiveData)
//    testImplementation(Lifecycles.testLifecycleRuntime)



}