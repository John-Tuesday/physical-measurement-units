import io.github.john.tuesday.measurement.MavenGroupId
import io.github.john.tuesday.measurement.MavenVersion

plugins {
    id("measure.kotlin.library")
    id("measure.kotlin.library.jvm")
    id("measure.kotlin.library.native")
    id("measure.maven.publish")
    alias(libs.plugins.dokka)
}

group = MavenGroupId
version = MavenVersion

publishing {
    publications.withType<MavenPublication>().configureEach {
        pom.name = "Physical Measurement Units Test Fixtures"
        pom.description = "Simple Kotlin Multiplatform library which supplies test helpers for Mass, Volume, and Length"
    }
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":measure:measure"))
                implementation(libs.kotlin.test)
            }
        }
    }
}

