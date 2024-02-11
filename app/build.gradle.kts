plugins {
    id(Config.Plugins.androidApplication)
    id(Config.Plugins.kotlinAndroid)
    id(Config.Plugins.kotlinKapt)
    id(Config.Plugins.hilt)
    id(Config.Plugins.google_secrets)
    id(Config.Plugins.checkDependencyUpdates) version "1.5.0"
}

android {
    namespace = "app.te.jahez"
    compileSdk = Config.AppConfig.compileSdkVersion

    defaultConfig {
        applicationId = Config.AppConfig.appId
        minSdk = Config.AppConfig.minSdkVersion
        targetSdk = Config.AppConfig.compileSdkVersion
        versionCode = Config.AppConfig.versionCodeTest
        versionName = Config.AppConfig.versionName
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
        testInstrumentationRunner = Config.AppConfig.testRunner
        resourceConfigurations.apply {
            add("ar")
            add("en")
        }
    }

    buildTypes {
        signingConfigs {
            create("releaseConfig") {
                storeFile = file("/home/t-e-s/Osman.jks")
                storePassword = "te2018"
                keyAlias = "te"
                keyPassword = "te2018"
            }
        }
        getByName("debug") {
            isDebuggable = true
            manifestPlaceholders["appName"] = "@string/app_name_debug"
            manifestPlaceholders["appIcon"] = "@mipmap/ic_launcher"
            manifestPlaceholders["appRoundIcon"] = "@mipmap/ic_launcher_round"
        }



        getByName("release") {
            signingConfig = signingConfigs.getByName("releaseConfig")
            isMinifyEnabled = true
            isShrinkResources = true
            manifestPlaceholders["appName"] = "@string/app_name"
            manifestPlaceholders["appIcon"] = "@mipmap/ic_launcher"
            manifestPlaceholders["appRoundIcon"] = "@mipmap/ic_launcher_round"
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Config.Plugins.kotlinCompilerExtensionVersion

    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
        buildConfig =true
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    bundle {
        language {
            enableSplit = false
        }
    }
    kapt {
        correctErrorTypes = true
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))


    // Hilt
    implementation(Libraries.hilt)
    kapt(Libraries.hiltDaggerCompiler)
    kapt(Libraries.hilt_compose_compiler)

    // Arch Components
    implementation(Libraries.viewModel)
    implementation(Libraries.lifeData)
    implementation(Libraries.lifecycle)
    implementation(Libraries.viewModelState)

    // Kotlin Coroutines
    implementation(Libraries.coroutinesCore)
    implementation(Libraries.coroutinesAndroid)

    implementation(Libraries.splash_screen)

    implementation(project(path =Config.Modules.core))
    implementation(project(path =Config.Modules.chat))

}
