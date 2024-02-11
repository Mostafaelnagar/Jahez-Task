plugins {
    id(Config.Plugins.androidLibrary)
    id(Config.Plugins.kotlinAndroid)
    id(Config.Plugins.kotlinKapt)
    id(Config.Plugins.hilt)
}

android {
    namespace = "te.app.storage"
    compileSdk = Config.AppConfig.compileSdkVersion

    defaultConfig {
        minSdk = Config.AppConfig.minSdkVersion
        testInstrumentationRunner = Config.AppConfig.testRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

    }
    buildFeatures {
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    externalNativeBuild {
        cmake {
            path = file("CMakeLists.txt")
        }
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    //HILT
    implementation(Libraries.hilt)
    kapt(Libraries.hiltDaggerCompiler)
    kapt(Libraries.hilt_compose_compiler)
}