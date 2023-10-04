pluginManagement {
    includeBuild("build-logic")
    repositories {
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

rootProject.name = "physical-measurement-units"
include(":measure:measure-test")
include(":measure:measure")
