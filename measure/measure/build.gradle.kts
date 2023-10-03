import org.calamarfederal.physical.measurement.MavenGroupId
import org.calamarfederal.physical.measurement.MavenVersion

plugins {
    id("measure.kotlin.library")
    id("measure.kotlin.library.jvm")
    id("measure.kotlin.library.native")
    `maven-publish`
}

group = MavenGroupId
version = MavenVersion

dependencies {
    commonTestImplementation(project(":measure:test"))
    commonTestImplementation(libs.kotlin.test)
    jvmTestImplementation(libs.junit.jupiter)
    jvmTestRuntimeOnly(libs.junit.platform.launcher)
}
