/**
 * Created by Iqbal Fauzi on 12/24/20 2:14 PM
 * iqbal.fauzi.if99@gmail.com
 */
object Apps {
    const val compileSdk = 30
    const val buildTools = "30.0.2"
    const val minSdk = 21
    const val targetSdk = 30
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    const val gradle = "4.1.2"
    const val kotlin = "1.4.30"
    const val multidex = "1.0.3"
    /* KTX */
    const val coreKtx = "1.3.2"
    const val fragmentKtx = "1.3.0"
    const val collectionKtx = "1.1.0"
    const val preferenceKtx = "1.1.1"

    /* UI */
    const val appcompat = "1.2.0"
    const val materialDesign = "1.2.1"
    const val constraintLayout = "2.0.4"
    const val swipeRefreshLayout = "1.1.0"
    const val viewPager2 = "1.0.0"
    const val circleImageView = "3.1.0"
    const val coil = "1.0.0" // Image Loader
    const val chromeTab = "1.3.0"
    const val pageIndicator = "1.0.6"

    /* SDK & Utilities */
    const val jodaTime = "2.10.0"
    const val qiscusSDK = "2.10.8"
    const val qrGenerator = "1.0.4"
    const val zxingQr = "3.4.0"

    /* Logger */
    const val timber = "4.7.1"
    const val timberKt = "1.5.1"
    const val prettyLogger = "2.2.0"

    /* Room Persistence */
    const val room = "2.2.6"

    /* Session */
    const val hawk = "2.0.1"

    /* Networking */
    const val coroutines = "1.4.1"
    // Retrofit
    const val retrofit = "2.9.0"
    const val retrofitCoroutinesAdapter = "0.9.2"
    const val sandwich = "1.0.8"
    // OkHttp
    const val okHttp = "4.9.0"
    // Moshi
    const val moshi = "1.11.0"
    const val moshiKotlin = "1.9.3"
    const val moshiRetrofitConverter = "2.9.0"
    const val codeGen = "1.9.2"

    /* ViewModel */
    const val viewModel = "2.2.0"

    /* Koin - Dependency Injection */
    const val koin = "2.2.0"

    /* test */
    const val junit = "4.13.1"
    const val mockito = "3.6.0"
}

object Libs {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
}

object TestLibs {
    const val junit = "junit:junit:${Versions.junit}"
}