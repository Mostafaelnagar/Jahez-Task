plugins {
    id(Config.Plugins.androidLibrary)
    id(Config.Plugins.kotlinAndroid)
    id(Config.Plugins.kotlinKapt)
}

android {
    namespace = "app.te.core"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Config.Plugins.kotlinCompilerExtensionVersion
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {


    //========== Compose================
    api(Libraries.kotlin_collections)
    api(Libraries.compose_material_icon)
    api(Libraries.compose_run_time)
    api(Libraries.compose_ui)
    api(Libraries.compose_ui_tooling)
    api(Libraries.compose_ui_preview)
    api(Libraries.compose_foundation)
    api(Libraries.compose_material)
    api(Libraries.compose_material_window_size)
    api(Libraries.compose_activity)
    api(Libraries.compose_constraint_layout)
    api(Libraries.compose_pager)
    api(Libraries.compose_lifeCycle)

    // =========Nav compose============
    api(Libraries.navigationHiltCompose)
    api(Libraries.navigationCompose)

    // UI
    api(Libraries.loadingAnimations)
    api(Libraries.coil)
    api(Libraries.shimmer)

    // Utils
    api(Libraries.playServices)
    api(Libraries.localization)
    api(Libraries.multidex)
    api(Libraries.gson)

    // =========Modules============
    api(project(path = Config.Modules.network))
    api(project(path = Config.Modules.navigation))

}