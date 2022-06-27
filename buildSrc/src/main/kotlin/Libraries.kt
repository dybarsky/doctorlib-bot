object Libraries {

    object Kotlin {
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.coroutines}"
        const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Kotlin.coroutines}"
        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.Kotlin.serialization}"
    }

    object AndroidX {
        const val ktxCore = "androidx.core:core-ktx:${Versions.AndroidX.ktxCore}"
        const val ktxCollections = "androidx.collection:collection-ktx:${Versions.AndroidX.ktxCollections}"
        const val ktxViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.AndroidX.ktxViewModel}"

        const val appCompat = "androidx.appcompat:appcompat:${Versions.AndroidX.appCompat}"
        const val cardView = "androidx.cardview:cardview:${Versions.AndroidX.cardView}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constraintLayout}"
        const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.AndroidX.recyclerView}"
        const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.AndroidX.lifecycle}"
        const val swipeToRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.AndroidX.swipeToRefresh}"
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.AndroidX.navigation}"
        const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.AndroidX.navigation}"
    }

    object Compose {
        const val ui = "androidx.compose.ui:ui:${Versions.AndroidX.compose}"
        const val animation = "androidx.compose.animation:animation:${Versions.AndroidX.compose}"
        const val foundation = "androidx.compose.foundation:foundation:${Versions.AndroidX.compose}"
        const val material = "androidx.compose.material:material:${Versions.AndroidX.compose}"
        const val tooling = "androidx.compose.ui:ui-tooling:${Versions.AndroidX.compose}"
    }

    object Google {
        const val material = "com.google.android.material:material:${Versions.Google.materialDesign}"
    }

    object Network {
        const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.Libs.okHttp}"
        const val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.Libs.okHttp}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.Libs.retrofit}"
        const val retrofitSerialization = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.Libs.retrofitSerialization}"
    }

    object Koin {
        const val core = "org.koin:koin-core:${Versions.Libs.koin}"
        const val ext = "org.koin:koin-core-ext:${Versions.Libs.koin}"
        const val test = "org.koin:koin-test:${Versions.Libs.koin}"
        const val android = "org.koin:koin-android:${Versions.Libs.koin}"
        const val androidXScope = "org.koin:koin-androidx-scope:${Versions.Libs.koin}"
        const val androidXViewModel = "org.koin:koin-androidx-viewmodel:${Versions.Libs.koin}"
        const val androidXFragment = "org.koin:koin-androidx-fragment:${Versions.Libs.koin}"
        const val androidXExt = "org.koin:koin-androidx-ext:${Versions.Libs.koin}"
    }

    object Test {
        const val jUnit = "junit:junit:${Versions.Test.jUnit}"
        const val mockito = "org.mockito:mockito-core:${Versions.Test.mockito}"
        const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.Test.mockitoKotlin}"
    }
}
