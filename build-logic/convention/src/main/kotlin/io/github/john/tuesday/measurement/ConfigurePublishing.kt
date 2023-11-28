package io.github.john.tuesday.measurement

import org.gradle.api.publish.maven.MavenPomDeveloperSpec
import org.gradle.kotlin.dsl.assign


const val MavenGroupId = "io.github.john-tuesday"
const val MavenVersion = "2.0.0-alpha03"
const val GitUrl = "https://github.com/John-Tuesday/physical-measurement-units"

internal fun MavenPomDeveloperSpec.johnTuesday() {
    developer {
        id = "John-Tuesday"
        name = "John Tuesday Picot"
        email = "calamarfederal.messyink@gmail.com"
    }
}

