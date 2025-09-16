pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven{ url = uri("https://maven.amap.com/repository/3d")
        //content{includeGroupByRegex("com\\.amap\\.api.*")}
        }
        maven{ url = uri("https://maven.amap.com/repository/search")
        //content{includeGroupByRegex("com\\.amap\\.api.*")}
        }
    }
}

rootProject.name = "Treasure"
include(":app")
 