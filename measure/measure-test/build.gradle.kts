import org.calamarfederal.physical.measurement.MavenGroupId
import org.calamarfederal.physical.measurement.MavenVersion

plugins {
    id("measure.kotlin.library")
    id("measure.kotlin.library.jvm")
    id("measure.kotlin.library.native")
    id("measure.maven.publication")
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

