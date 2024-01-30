plugins {
    id("com.android.application")
    id("com.google.devtools.ksp")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
    kotlin("android")
}

android {
    namespace = "com.achmad.baseandroid"
    compileSdk = 34
    buildToolsVersion = "34.0.0"

    defaultConfig {
        applicationId = "com.achmad.baseandroid"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"

        val baseUrl: String by project
        buildConfigField("String", "BASE_URL", baseUrl)
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    buildFeatures {
        compose = true
        dataBinding = false
        viewBinding = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }

    kotlinOptions {
        jvmTarget = "18"
    }

    packagingOptions {
        resources.excludes.addAll(
            listOf(
                "META-INF/*",
            ),
        )
    }
}

dependencies {
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.4")

    // Kotlin
    val coroutinesVersion = "1.7.3"
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.22")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${coroutinesVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")

    // Android
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")

    // UI
    val activityVersion = "1.8.2"
    implementation("androidx.activity:activity-ktx:${activityVersion}")
    implementation("androidx.fragment:fragment-ktx:1.6.2")

    // Compose
    implementation(platform("androidx.compose:compose-bom:2022.12.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.runtime:runtime-livedata")
    implementation("androidx.activity:activity-compose:${activityVersion}")
    implementation("io.coil-kt:coil-compose:2.4.0")

    // DI
    val hiltVersion = "2.48"
    implementation("com.google.dagger:hilt-android:${hiltVersion}")
    ksp("com.google.dagger:hilt-android-compiler:${hiltVersion}")
    implementation("javax.inject:javax.inject:1")

    // Network
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.15.0")
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.15.0")
    implementation("com.github.skydoves:sandwich:1.3.2")
    debugImplementation("com.github.chuckerteam.chucker:library:4.0.0")
    releaseImplementation("com.github.chuckerteam.chucker:library-no-op:3.5.2")

    // Room
    val roomVersion = "2.6.1"
    implementation("androidx.room:room-ktx:${roomVersion}")
    ksp("androidx.room:room-compiler:${roomVersion}")

    // Test
    testImplementation(kotlin("test"))
    testImplementation("junit:junit:4.13.2")
    testImplementation("io.mockk:mockk:1.13.3")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${coroutinesVersion}")
    testImplementation("androidx.arch.core:core-testing:2.2.0")

    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.6.0")
    androidTestImplementation("io.mockk:mockk-android:1.13.3")
    androidTestImplementation("com.google.dagger:hilt-android-testing:${hiltVersion}")
    kspAndroidTest("com.google.dagger:hilt-android-compiler:${hiltVersion}")
}
