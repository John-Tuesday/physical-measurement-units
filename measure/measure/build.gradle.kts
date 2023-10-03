plugins {
    id("measure.kotlin.library")
    id("measure.kotlin.library.jvm")
    id("measure.kotlin.library.native")
}

dependencies {
    commonTestImplementation(project(":measure:test"))
    commonTestImplementation(libs.kotlin.test)
    jvmTestImplementation(libs.junit.jupiter)
    jvmTestRuntimeOnly(libs.junit.platform.launcher)
}
