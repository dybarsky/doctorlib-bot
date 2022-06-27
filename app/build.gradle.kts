val apiUrl: String by project
val apiKey: String by project

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("io.gitlab.arturbosch.detekt")
}

android {
    appVersions()
    sdkVersions()
    compileOptions()
    composeOptions()
    kotlinSourceSet()
    testOptions(project.reportsDir())
    lintOptions(project.reportsDir())
    buildFeatures {
        buildConfig = true
        viewBinding = true
        compose = true
    }
    defaultConfig {
        applicationId = "dybarsky.app"
        vectorDrawables.useSupportLibrary = true
    }
    buildTypes {
        getByName("debug") {
            buildConfigField("String", "API_URL", apiUrl)
            buildConfigField("String", "API_KEY", apiKey)
        }
        getByName("release") {
            buildConfigField("String", "API_URL", apiUrl)
            buildConfigField("String", "API_KEY", apiKey)
        }
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation(project(":domain"))
    implementation(project(":gateway"))
    implementation(project(":interactors"))
    implementation(project(":ui"))

    koinAndroid()
}
