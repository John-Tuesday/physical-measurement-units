import io.github.john.tuesday.measurement.MavenVersion

plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.dokka) apply true
    id("measure.kotlin.library") apply false
}

version = MavenVersion

tasks.dokkaHtmlMultiModule {
    outputDirectory = projectDir.resolve("docs/documentation")
}
