object Versions {

    const val androidVersionCode = 1
    const val androidVersionName = "0.1"

    object Sdk {
        const val min = 21
        const val compile = 30
        const val target = 30
    }

    object Gradle {
        const val agp = "7.2.1"
        const val safeArgs = "2.4.2"
        const val versions = "0.42.0"
        const val detekt = "1.20.0"
        const val ktlint = "10.3.0"
    }

    object Kotlin {
        const val datetime = "0.2.1"
        const val std = "1.6.21"
        const val coroutines = "1.6.3"
        const val serialization = "1.3.3"
    }

    object AndroidX {
        const val ktxCore = "1.8.0"
        const val ktxViewModel = "2.4.1"
        const val ktxCollections = "1.2.0"

        const val appCompat = "1.4.2"
        const val cardView = "1.0.0"
        const val constraintLayout = "2.1.4"
        const val lifecycle = "2.2.0"
        const val navigation = "2.4.2"
        const val recyclerView = "1.2.1"
        const val swipeToRefresh = "1.1.0"

        const val compose = "1.1.1"
    }

    object Google {
        const val materialDesign = "1.6.1"
    }

    object Libs {
        const val koin = "2.2.2"
        const val okHttp = "4.10.0"
        const val retrofit = "2.9.0"
        const val retrofitSerialization = "0.8.0"
    }

    object Test {
        const val jUnit = "4.13.2"
        const val mockito = "4.6.1"
        const val mockitoKotlin = "2.2.0"
    }

    object Tools {
        const val ktlint = "0.46.1"
    }
}
