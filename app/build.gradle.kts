plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("kotlin-android")
}

android {
    compileSdkVersion(Apps.compileSdk)
    buildToolsVersion("30.0.2")

    defaultConfig {
        applicationId("com.iqbalfauzi.moviejetpack")
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)
        versionCode = Apps.versionCode
        versionName = Apps.versionName
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "API_KEY", "\"${Properties.API_KEY}\"")
        buildConfigField("String", "BASE_URL", "\"${Properties.BASE_URL}\"")
        buildConfigField("String", "BASE_IMAGE_URL", "\"${Properties.BASE_IMAGE_URL}\"")

        javaCompileOptions {
            annotationProcessorOptions {
                arguments["room.incremental"] = "true"
            }
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isDebuggable = false
//            isShrinkResources = true
//            isZipAlignEnabled = true
//            isJniDebuggable = false
//            isRenderscriptDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
//            signingConfig = signingConfigs.getByName("release")
        }
        getByName("debug") {
            isDebuggable = true
            applicationIdSuffix = ".dev"
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    packagingOptions {
        exclude("META-INF/metadata.kotlin_module")
        exclude("META-INF/metadata.jvm.kotlin_module")
    }
}

dependencies {
    // KOTLIN
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}")
    // KTX
    implementation("androidx.core:core-ktx:${Versions.coreKtx}")
    implementation("androidx.fragment:fragment-ktx:${Versions.fragmentKtx}")
    implementation("androidx.collection:collection-ktx:${Versions.collectionKtx}")
    implementation("androidx.preference:preference-ktx:${Versions.preferenceKtx}")
    /* UI */
    implementation("androidx.appcompat:appcompat:${Versions.appcompat}")
    implementation("com.google.android.material:material:${Versions.materialDesign}")
    implementation("androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("androidx.viewpager2:viewpager2:${Versions.viewPager2}")
    implementation("io.coil-kt:coil:${Versions.coil}") // Image Loader
    implementation("de.hdodenhof:circleimageview:${Versions.circleImageView}")
    implementation("com.facebook.shimmer:shimmer:0.5.0")
    implementation("com.github.rbro112:Android-Indefinite-Pager-Indicator:1.4")
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${Versions.viewModel}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${Versions.viewModel}")
    implementation("androidx.lifecycle:lifecycle-reactivestreams-ktx:${Versions.viewModel}")
    implementation("androidx.lifecycle:lifecycle-extensions:${Versions.viewModel}")
    /* Room Persistence */
    implementation("androidx.room:room-runtime:${Versions.room}")
    implementation("androidx.room:room-ktx:${Versions.room}")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    kapt("androidx.room:room-compiler:${Versions.room}")
    testImplementation("androidx.room:room-testing:${Versions.room}")
    // Logger
    implementation("com.jakewharton.timber:timber:${Versions.timber}")
    implementation("com.github.ajalt:timberkt:${Versions.timberKt}")
    implementation("com.orhanobut:logger:${Versions.prettyLogger}")
    // Kotlin Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}")
    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:${Versions.retrofit}")
    implementation("com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}")
    implementation("com.squareup.retrofit2:converter-moshi:${Versions.moshiRetrofitConverter}")
    implementation("com.github.skydoves:sandwich:${Versions.sandwich}")
    // Moshi
    implementation("com.squareup.moshi:moshi-kotlin:${Versions.moshiKotlin}")
    implementation("com.squareup.moshi:moshi-kotlin-codegen:${Versions.codeGen}")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:${Versions.codeGen}")
    // Koin AndroidX (Dependency Injection)
    implementation("org.koin:koin-androidx-scope:${Versions.koin}")
    implementation("org.koin:koin-androidx-viewmodel:${Versions.koin}")
    implementation("org.koin:koin-androidx-ext:${Versions.koin}")
    debugImplementation("com.squareup.leakcanary:leakcanary-android:2.6")
    // TDD
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito:mockito-core:$${Versions.mockito}")
    testImplementation("org.mockito:mockito-inline:${Versions.mockito}")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("com.kaspersky.android-components:kaspresso:1.2.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}