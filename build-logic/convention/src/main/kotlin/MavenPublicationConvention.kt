import io.github.john.tuesday.measurement.GitUrl
import io.github.john.tuesday.plugins.MavenPublishAssistPlugin
import io.github.john.tuesday.plugins.helper.*
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.*

class MavenConvention : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(MavenPublishAssistPlugin::class)
            val publishing = extensions.getByType<PublishingExtension>()
            publishing.repositories {
                maven {
                    usePreset(SonatypeStaging, providers)
                }
                maven {
                    usePreset(GitHubPackages("physical-measurement-units"), providers)
                }
            }
            publishing.publications.withType<MavenPublication>().configureEach {
                pom {
                    name = "Physical Measurement Units"
                    description = "Simple Kotlin Multiplatform library which supplies Mass, Volume, and Length"
                    url = GitUrl

                    scm {
                        url = GitUrl
                    }
                    licenses {
                        license(LicensePreset.MIT)
                    }
                    developers {
                        johnTuesday()
                    }
                }
            }
        }
    }
}
