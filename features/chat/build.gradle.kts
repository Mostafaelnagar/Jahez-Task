plugins {
    id(Config.Plugins.androidLibrary)
    id(Config.Plugins.kotlinAndroid)
    id(Config.Plugins.kotlinKapt)
    id(Config.Plugins.kotlin_parcable)
    id(Config.Plugins.hilt)

}

android {
    namespace = "te.app.chat"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Config.Plugins.kotlinCompilerExtensionVersion

    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // Hilt
    implementation(Libraries.hilt)
    kapt(Libraries.hiltDaggerCompiler)
    kapt(Libraries.hilt_compose_compiler)
    implementation (Libraries.socket_client)
    //Room
    implementation(Libraries.roomVersion)
    kapt(Libraries.roomCompiler)
    implementation(Libraries.roomktx)
    implementation(Libraries.roomCommon)

    implementation(project(path = Config.Modules.core))
}