package org.calamarfederal.physical.measurement

import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPomDeveloperSpec
import org.gradle.api.publish.maven.MavenPomLicenseSpec
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.withType
import java.util.*

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

internal fun PublishingExtension.configureMaven(
    getJar: () -> Jar
) {
    publications.withType<MavenPublication> {
        artifact(getJar())

        pom {
            name.set("Physical Measurement Units")
            description.set("Simple Kotlin Multiplatform library which supplies Mass, Volume, and Length")
            url.set(GitUrl)

            licenses {
                mit()
            }
            developers {
                johnTuesday()
            }
            scm {
                url.set(GitUrl)
            }
        }
    }
}

internal fun MavenPomLicenseSpec.mit() {
    license {
        name.set("MIT")
        url.set("https://opensource.org/licenses/MIT")
    }
}

internal fun MavenPomDeveloperSpec.johnTuesday() {
    developer {
        id.set("John-Tuesday")
        name.set("John Tuesday Picot")
        email.set("calamarfederal.messyink@gmail.com")
    }
}

