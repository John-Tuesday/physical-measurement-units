import io.github.john.tuesday.measurement.MavenGroupId
import io.github.john.tuesday.measurement.MavenVersion

plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.dokka.convention.html) apply true
    alias(libs.plugins.maven.assist) apply false
    id("measure.kotlin.library.multiplatform") apply false
    id("measure.maven.publish") apply false
}

group = MavenGroupId
version = MavenVersion
