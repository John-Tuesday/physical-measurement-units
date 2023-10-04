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

dependencies {
    commonMainApi(project(":measure:measure"))
    commonMainImplementation(libs.kotlin.test)
}
