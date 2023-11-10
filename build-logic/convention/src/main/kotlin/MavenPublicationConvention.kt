import io.github.john.tuesday.measurement.GitUrl
import io.github.john.tuesday.measurement.johnTuesday
import io.github.john.tuesday.plugins.MavenPublishAssistPlugin
import io.github.john.tuesday.plugins.publishing.model.LicensePreset
import io.github.john.tuesday.plugins.publishing.model.MavenRepository
import io.github.john.tuesday.plugins.publishing.model.license
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.credentials.PasswordCredentials
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.*

class MavenConvention : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(MavenPublishAssistPlugin::class)
            pluginManager.withPlugin("maven-publish") {
                val publishing = extensions.getByType<PublishingExtension>()
                publishing.repositories {
                    maven {
                        setUrl(MavenRepository.SonatypeStaging.url)
                        credentials(PasswordCredentials::class)
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
}
