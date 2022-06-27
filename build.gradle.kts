import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import io.gitlab.arturbosch.detekt.Detekt
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jlleitschuh.gradle.ktlint.KtlintExtension

val revisions: String? by project

buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", version = Versions.Kotlin.std))
        classpath("com.android.tools.build:gradle:${Versions.Gradle.agp}")
        classpath("org.koin:koin-gradle-plugin:${Versions.Libs.koin}")
        classpath("com.github.ben-manes:gradle-versions-plugin:${Versions.Gradle.versions}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.Gradle.safeArgs}")
        classpath("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${Versions.Gradle.detekt}")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:${Versions.Gradle.ktlint}")
    }
}

apply {
    plugin("kotlin")
    plugin("kotlin-kapt")
    plugin("android-reporting")
    plugin("com.github.ben-manes.versions")
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
    tasks {
        withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = "1.8"
                freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
            }
        }
    }
}

// Detekt configuration
subprojects {
    tasks.withType<Detekt> {
        config.setFrom(files("$rootDir/detekt.yml"))
        setSource(files(
                "src/main/kotlin",
                "src/main/java",        // todo: move kotlin files
                "src/mobile/kotlin",
                "src/mobile/java",      // todo: move kotlin files
                "src/tv/kotlin",
                "src/tv/java",          // todo: move kotlin files
                "src/test/kotlin",
                "src/test/java",        // todo: move kotlin files
        ))
        reports {
            txt {
                destination = file("build/reports/detekt/detekt.txt")
            }
        }
        include("**/*.kt", "**/*.kts")
        exclude("resources/", "generated/", "build/")
        // See config here: https://detekt.github.io/detekt/gradle.html#kotlin-dsl-3
    }
}

// Ktlint configuration
subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    configure<KtlintExtension> {
        version.set(Versions.Tools.ktlint)
        debug.set(true)
        coloredOutput.set(false)
        // See config here: https://github.com/JLLeitschuh/ktlint-gradle#configuration
    }
}

tasks {

    // Add unit-tests task to run testMobileDebugUnitTest task in all subprojects
    val unitTestTask = register("unit-tests") {
        group = "verification"
        val testTasks = findTasks("testDebugUnitTest")
        val reportTask = getByName("printTestReport")
        reportTask.mustRunAfter(testTasks)
        dependsOn(testTasks + reportTask)
    }

    // Add ui-tests task as short alias for connectedMobileDebugAndroidTest
    val uiTestTask = register("ui-tests") {
        group = "verification"
        dependsOn(":app:mobile:connectedDebugAndroidTest")
    }

    // Add kotlin code checks task
    val checksTask = register("kotlin-checks") {
        group = "verification"
        val ktlint = findTasks("ktlintCheck")
        val detekt = findTasks("detekt")
        dependsOn(ktlint + detekt)
    }

    // Configure libs versions plugin - filter versions passed as -Previsions=...
    withType<DependencyUpdatesTask> {
        val keywords = mutableListOf("alpha", "beta", "rc")
            .apply {
                remove(revisions)
            }
        rejectVersionIf {
            keywords.any { candidate.version.contains(it, ignoreCase = true) }
        }
    }
}

fun findTasks(name: String) = subprojects
    .mapNotNull { subproject ->
        subproject.tasks.findByName(name)?.let {
            "${subproject.path}:$name"
        }
    }

