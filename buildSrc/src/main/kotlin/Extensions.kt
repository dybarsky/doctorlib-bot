import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import java.io.File

// Dependencies extensions

fun DependencyHandler.compile(depName: String) = add("compileOnly", depName)
fun DependencyHandler.implementation(depName: String) = add("implementation", depName)
fun DependencyHandler.test(depName: String) = add("testImplementation", depName)
fun DependencyHandler.api(depName: String) = add("api", depName)
fun DependencyHandler.kapt(depName: String) = add("kapt", depName)

// Application extensions

fun ApplicationExtension.kotlinSourceSet() = sourceSets {
    map { it.java.srcDir("src/${it.name}/kotlin") }
}

fun ApplicationExtension.testOptions(reportsDir: String) = testOptions {
    reportDir = "$reportsDir/tests"
}

fun ApplicationExtension.composeOptions() = composeOptions {
    kotlinCompilerExtensionVersion = Versions.AndroidX.compose
}

fun ApplicationExtension.compileOptions() = compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

fun ApplicationExtension.appVersions() = defaultConfig {
    defaultConfig {
        versionCode = Versions.androidVersionCode
        versionName = Versions.androidVersionName
    }
}

fun ApplicationExtension.sdkVersions() = defaultConfig {
    minSdk = Versions.Sdk.min
    targetSdk = Versions.Sdk.target
    compileSdk = Versions.Sdk.compile
}

fun ApplicationExtension.lintOptions(reportsDir: String) = lintOptions {
    isCheckDependencies = true
    isAbortOnError = true
    xmlOutput = File("$reportsDir/lint/lint-results.xml")
    htmlOutput = File("$reportsDir/reports/lint/lint-results.html")
}

// Library extensions

fun LibraryExtension.kotlinSourceSet() = sourceSets {
    map { it.java.srcDir("src/${it.name}/kotlin") }
}

fun LibraryExtension.testOptions(reportsDir: String) = testOptions {
    reportDir = "$reportsDir/tests"
}

fun LibraryExtension.compileOptions() = compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

fun LibraryExtension.composeOptions() = composeOptions {
    kotlinCompilerExtensionVersion = Versions.AndroidX.compose
}

fun LibraryExtension.sdkVersions() = defaultConfig {
    minSdk = Versions.Sdk.min
    targetSdk = Versions.Sdk.target
    compileSdk = Versions.Sdk.compile
}

fun LibraryExtension.lintOptions(reportsDir: String) = lintOptions {
    isCheckDependencies = true
    isAbortOnError = true
    xmlOutput = File("$reportsDir/lint/lint-results.xml")
    htmlOutput = File("$reportsDir/reports/lint/lint-results.html")
}

fun Project.reportsDir() = "${buildDir.absolutePath}/reports"
