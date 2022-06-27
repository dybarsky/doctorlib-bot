plugins {
    kotlin("jvm")
    kotlin("kapt")
    kotlin("plugin.serialization") version Versions.Kotlin.std
    id("io.gitlab.arturbosch.detekt")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation(project(":domain"))

    koin()
    okHttp()
    retrofit()
    serialization()
}
