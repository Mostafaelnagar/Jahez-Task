object Config {
    object AppConfig {
        const val appId = "app.te.hero_cars"
        const val compileSdkVersion = 34
        const val minSdkVersion = 23
        const val versionCode = 8
        const val versionCodeTest = 16
        const val versionName = "15-09-2022 (1.7)"
        const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    object Dependencies {
        const val snapshots = "https://oss.sonatype.org/content/repositories/snapshots/"
        const val jitPackURL = "https://jitpack.io"
        const val gradleVersion = "com.android.tools.build:gradle:${Versions.gradleVersion}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}"
        const val google_secret =
            "com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:${Versions.google_secret}"

    }

    object Plugins {
        const val androidApplication = "com.android.application"
        const val androidLibrary = "com.android.library"
        const val kotlinAndroid = "org.jetbrains.kotlin.android"
        const val kotlinKapt = "kotlin-kapt"
        const val hilt = "dagger.hilt.android.plugin"
        const val kotlin_parcable = "kotlin-parcelize"
        const val ktLint = "org.jlleitschuh.gradle.ktlint"
        const val google_secrets = "com.google.android.libraries.mapsplatform.secrets-gradle-plugin"
        const val checkDependencyUpdates = "name.remal.check-dependency-updates"
        const val kotlinCompilerExtensionVersion = "1.5.1"
    }

    object Modules {
        const val storage = ":storage"
        const val network = ":network"
        const val core = ":core"
        const val chat = ":features:chat"
        const val navigation = ":Navigation"
    }

}