pluginManagement {
    includeBuild("build-logic")
    repositories {
        mavenCentral()
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/john-tuesday/gradle-convention-plugins")
            credentials {
                username = providers
                    .gradleProperty("gpr.user")
                    .orElse(providers.environmentVariable("USERNAME"))
                    .orNull ?: error("Expected to find property 'gpr.user' or environment variable 'USERNAME' but found nothing")
                password = providers
                    .gradleProperty("gpr.key")
                    .orElse(providers.environmentVariable("TOKEN"))
                    .orNull ?: error("Expected to find property 'gpr.key' or environment variable 'TOKEN' but found nothing")
            }
        }
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
