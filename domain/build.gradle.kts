plugins {
    kotlin("jvm")
    kotlin("kapt")
    id("io.gitlab.arturbosch.detekt")
}
dependencies {
    implementation(kotlin("stdlib-jdk8"))

    koin()
}

