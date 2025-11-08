pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://jitpack.io")

        maven("https://central.sonatype.com/repository/maven-snapshots/")
        maven {
            url = uri("https://company/com/maven2")
        }
        mavenLocal()
        flatDir {
            dirs("libs")
        }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

rootProject.name = "RotbeYar"
include(":app")