import io.github.john.tuesday.measurement.configureMaven
import io.github.john.tuesday.measurement.configureRepositories
import io.github.john.tuesday.measurement.configureSecrets
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.publish.maven.tasks.AbstractPublishToMaven
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.*
import org.gradle.plugins.signing.SigningExtension
import org.gradle.plugins.signing.SigningPlugin

class MavenPublicationConvention : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("maven-publish")
                apply<SigningPlugin>()
            }

            configureSecrets()

            val javadocJar by tasks.registering(Jar::class) {
                archiveClassifier = "javadoc"
            }

            val publishing = extensions.getByType<PublishingExtension>()
            afterEvaluate {
                publishing.apply {
                    configureRepositories(
                        extra["ossrhUsername"].toString(),
                        extra["ossrhPassword"].toString(),
                    )
                }
            }

            val mavenKotlin by publishing.publications.creating(MavenPublication::class) {
                artifact(javadocJar)
                configureMaven()
            }
            extensions.configure<SigningExtension> {
                useGpgCmd()
                sign(mavenKotlin)
            }

            val check by tasks.existing

            tasks.withType<AbstractPublishToMaven>().configureEach {
                dependsOn(check)
            }
        }
    }
}
