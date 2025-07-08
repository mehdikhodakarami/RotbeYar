pluginManagement {
    repositories {
        maven("https://central.sonatype.com/repository/maven-snapshots/")


        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        google()      // حتما باید برای Firebase باشه
        mavenCentral()
        maven("https://jitpack.io")



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
 