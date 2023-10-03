plugins {
    id("measure.kotlin.library")
    id("measure.kotlin.library.jvm")
    id("measure.kotlin.library.native")
}

dependencies {
    commonMainApi(project(":measure:measure"))
    commonMainImplementation(libs.kotlin.test)
}
