import io.github.john.tuesday.measurement.MavenGroupId
import io.github.john.tuesday.measurement.MavenVersion

plugins {
    id("measure.kotlin.library")
    id("measure.kotlin.library.jvm")
    id("measure.kotlin.library.native")
    id("measure.maven.publication")
    alias(libs.plugins.dokka)
}

group = MavenGroupId
version = MavenVersion

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

