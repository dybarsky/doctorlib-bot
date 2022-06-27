plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    sdkVersions()
    compileOptions()
    composeOptions()
    kotlinSourceSet()
    testOptions(project.reportsDir())
    lintOptions(project.reportsDir())
    buildFeatures {
        viewBinding = true
        compose = true
    }
    defaultConfig {
        vectorDrawables.useSupportLibrary = true
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation(project(":domain"))
    implementation(project(":interactors"))

    ktx()
    compose()
    koinAndroid()
    materialDesign()
    androidXCardView()
    androidXLifecycle()
    androidXNavigation()
    androidXRecyclerView()
    androidXSwipeToRefresh()
}

