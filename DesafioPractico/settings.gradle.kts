pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        id("com.android.application") version "8.1.0-alphaXX" // tu versión de AGP
        kotlin("android") version "2.0.0"  // usando Kotlin 2.0
        id("org.jetbrains.kotlin.plugin.compose") version "1.5.0-dev1234" // usa la versión recomendada por Compose para Kotlin 2.0
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "DesafioPractico"
include(":app")
