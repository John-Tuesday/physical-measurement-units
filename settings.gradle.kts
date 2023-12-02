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
                    .orElse(providers.systemProperty("gpr.user"))
                    .orElse(providers.environmentVariable("GPR_USERNAME"))
                    .orNull ?: error("Expected to find property 'gpr.user' or environment variable 'GPR_USERNAME'")
                password = providers
                    .gradleProperty("gpr.key")
                    .orElse(providers.systemProperty("gpr.key"))
                    .orElse(providers.environmentVariable("GPR_TOKEN"))
                    .orNull ?: error("Expected to find property 'gpr.key' or environment variable 'GPR_TOKEN'")
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
