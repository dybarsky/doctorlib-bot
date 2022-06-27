import org.gradle.api.artifacts.dsl.DependencyHandler


fun DependencyHandler.koin() {
    implementation(Libraries.Koin.core)
    implementation(Libraries.Koin.ext)
}

fun DependencyHandler.koinAndroid() {
    implementation(Libraries.Koin.android)
    implementation(Libraries.Koin.androidXExt)
    implementation(Libraries.Koin.androidXScope)
    implementation(Libraries.Koin.androidXFragment)
    implementation(Libraries.Koin.androidXViewModel)
}

fun DependencyHandler.coroutines() {
    implementation(Libraries.Kotlin.coroutines)
}

fun DependencyHandler.compose() {
    implementation(Libraries.Compose.ui)
    implementation(Libraries.Compose.foundation)
    implementation(Libraries.Compose.animation)
    implementation(Libraries.Compose.material)
}

fun DependencyHandler.okHttp() {
    implementation(Libraries.Network.okHttp)
    implementation(Libraries.Network.okHttpLogging)
}

fun DependencyHandler.serialization() {
    implementation(Libraries.Kotlin.serialization)
    implementation(Libraries.Network.retrofitSerialization)
}

fun DependencyHandler.retrofit() {
    implementation(Libraries.Network.retrofit)
}

fun DependencyHandler.ktx() {
    implementation(Libraries.AndroidX.ktxCore)
    implementation(Libraries.AndroidX.ktxCollections)
    implementation(Libraries.AndroidX.ktxViewModel)
}

fun DependencyHandler.androidXCore() {
    implementation(Libraries.AndroidX.appCompat)
    implementation(Libraries.AndroidX.constraintLayout)
}

fun DependencyHandler.androidXCardView() {
    androidXCore()
    implementation(Libraries.AndroidX.cardView)
}

fun DependencyHandler.androidXRecyclerView() {
    androidXCore()
    implementation(Libraries.AndroidX.recyclerView)
}

fun DependencyHandler.androidXLifecycle() {
    androidXCore()
    implementation(Libraries.AndroidX.lifecycle)
}

fun DependencyHandler.androidXSwipeToRefresh() {
    androidXCore()
    implementation(Libraries.AndroidX.swipeToRefresh)
}

fun DependencyHandler.androidXNavigation() {
    implementation(Libraries.AndroidX.navigationFragment)
    implementation(Libraries.AndroidX.navigationUI)
}

fun DependencyHandler.materialDesign() {
    androidXCore()
    implementation(Libraries.Google.material)
}

fun DependencyHandler.testing() {
    test(Libraries.Test.jUnit)
    test(Libraries.Koin.test)
    test(Libraries.Test.mockito)
    test(Libraries.Test.mockitoKotlin)
    test(Libraries.Kotlin.coroutinesTest)
}
