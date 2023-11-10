package io.github.john.tuesday.measurement

import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPomDeveloperSpec
import org.gradle.api.publish.maven.MavenPomLicenseSpec
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.assign
import org.gradle.kotlin.dsl.extra
import java.util.*


const val MavenGroupId = "io.github.john-tuesday"
const val MavenVersion = "2.0.0-alpha01"
internal const val GitUrl = "https://github.com/John-Tuesday/physical-measurement-units"

internal fun Project.configureSecrets() {
    extra["signing.keyId"] = null
    extra["signing.password"] = null
    extra["signing.gnupg.keyName"] = null
    extra["signing.gnupg.passphrase"] = null
    extra["ossrhUsername"] = null
    extra["ossrhPassword"] = null

    val propsFile = this.rootProject.file("local.properties")
    if (propsFile.exists()) {
        propsFile.reader().use {
            Properties().apply {
                load(it)
            }
        }.onEach { (name, value) ->
            extra[name.toString()] = value
        }
    }
}

internal fun PublishingExtension.configureRepositories(
    ossrhUsername: String?,
    ossrhPassword: String?,
) {
    repositories {
        maven {
            name = "sonatype"
            setUrl("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = ossrhUsername
                password = ossrhPassword
            }
        }
    }
}

internal fun MavenPublication.configureMaven() {
    pom {
        name = "Physical Measurement Units"
        description = "Simple Kotlin Multiplatform library which supplies Mass, Volume, and Length"
        url = GitUrl

        licenses {
            mit()
        }
        developers {
            johnTuesday()
        }
        scm {
            url = GitUrl
        }
    }

}

internal fun MavenPomLicenseSpec.mit() {
    license {
        name = "MIT"
        url = "https://opensource.org/licenses/MIT"
    }
}

internal fun MavenPomDeveloperSpec.johnTuesday() {
    developer {
        id = "John-Tuesday"
        name = "John Tuesday Picot"
        email = "calamarfederal.messyink@gmail.com"
    }
}

