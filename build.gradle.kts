// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val compose_ui_version by extra("1.1.1")
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Config.Dependencies.gradleVersion)
        classpath(Config.Dependencies.kotlin)
        classpath(Config.Dependencies.hilt)
        classpath(Config.Dependencies.google_secret)
    }
}

plugins {
    id(Config.Plugins.ktLint) version Versions.ktLint
}

subprojects {
    apply(plugin = Config.Plugins.ktLint) // To apply ktLint to all included modules

    repositories {
        mavenCentral()
    }

    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        debug.set(true)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = Config.Dependencies.snapshots)
        maven(url = Config.Dependencies.jitPackURL)

    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

tasks.register("installGitHooks", Copy::class) {
    from("${rootProject.rootDir}/pre-commit")
    into("${rootProject.rootDir}/.git/hooks")
}