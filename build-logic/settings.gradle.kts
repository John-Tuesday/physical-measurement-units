dependencyResolutionManagement {
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
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

rootProject.name = "build-logic"
include(":convention")
