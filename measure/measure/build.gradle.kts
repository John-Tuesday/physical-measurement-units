import io.github.john.tuesday.measurement.MavenGroupId
import io.github.john.tuesday.measurement.MavenVersion

plugins {
    id("measure.kotlin.library.multiplatform")
    id("measure.maven.publish")
    alias(libs.plugins.dokka.convention.html) apply true
}

group = MavenGroupId
version = MavenVersion

publishing {
    publications.withType<MavenPublication>().configureEach {
        pom.name = "Physical Measurement Units"
        pom.description = "Simple Kotlin Multiplatform library which supplies Mass, Volume, and Length"
    }
}

kotlin {
    sourceSets {
        val commonTest by getting {
            dependencies {
                implementation(project(":measure:measure-test"))
                implementation(libs.kotlin.test)
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(libs.junit.jupiter)
                runtimeOnly(libs.junit.platform.launcher)
            }
        }
    }
}
