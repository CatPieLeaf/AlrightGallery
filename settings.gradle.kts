pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://www.jitpack.io") }
//        maven { setUrl("https://artifactory-external.vkpartner.ru/artifactory/maven") }
        mavenLocal()
    }
}

rootProject.name = "Gallery"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":baselineprofile")

// TEMP: build against a local Goodwy Commons checkout (with a targeted cold-start fix)
// instead of the pinned jitpack artifact, since that fix lives in the commons lib, not here.
includeBuild("../GoodwyCommons") {
    dependencySubstitution {
        substitute(module("com.github.goodwy.goodwy-commons:commons-foss")).using(project(":commons"))
        substitute(module("com.github.goodwy.goodwy-commons:commons-gplay")).using(project(":commons"))
        substitute(module("com.github.goodwy.goodwy-commons:commons-rustore")).using(project(":commons"))
    }
}

