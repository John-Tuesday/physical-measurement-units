import io.github.john.tuesday.measurement.MavenGroupId
import io.github.john.tuesday.measurement.MavenVersion

plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.dokka) apply true
    alias(libs.plugins.maven.assist) apply false
    id("measure.kotlin.library") apply false
}

group = MavenGroupId
version = MavenVersion

val dokkaTask = tasks.dokkaHtmlMultiModule

dokkaTask {
    outputDirectory = rootProject.layout.projectDirectory.dir("docs/documentation")
}
