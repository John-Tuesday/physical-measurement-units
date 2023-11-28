import io.github.john.tuesday.measurement.GitUrl
import io.github.john.tuesday.measurement.johnTuesday
import io.github.john.tuesday.plugins.MavenPublishAssistPlugin
import io.github.john.tuesday.plugins.publishing.model.LicensePreset
import io.github.john.tuesday.plugins.publishing.model.MavenRepository
import io.github.john.tuesday.plugins.publishing.model.license
import io.github.john.tuesday.plugins.publishing.model.maven
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.publish.maven.tasks.AbstractPublishToMaven
import org.gradle.kotlin.dsl.*

class MavenConvention : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(MavenPublishAssistPlugin::class)
            val publishing = extensions.getByType<PublishingExtension>()
            publishing.repositories {
                maven(
                    repo = MavenRepository.SonatypeStaging,
                    providers = providers,
                )
                maven(
                    repo = MavenRepository.GitHubPackage(
                        owner = "john-tuesday",
                        repository = "physical-measurement-units"
                    ),
                    providers = providers,
                )
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
            tasks.withType<AbstractPublishToMaven>().configureEach {
                onlyIf {
                    name
                        .substringAfter("publish")
                        .substringBefore("Publication") in listOf("Jvm", "KotlinMultiplatform") &&
                            providers
                                .gradleProperty("isMainHost")
                                .orElse(providers.environmentVariable("IS_MAIN_HOST"))
                                .orNull == "true"
                }
            }
        }
    }
}
