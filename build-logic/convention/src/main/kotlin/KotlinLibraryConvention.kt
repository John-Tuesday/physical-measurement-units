import org.calamarfederal.physical.measurement.*
import org.calamarfederal.physical.measurement.configureJvm
import org.calamarfederal.physical.measurement.configureNative
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KotlinLibraryConvention : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("org.jetbrains.kotlin.multiplatform")
            }

            extensions.configure<KotlinMultiplatformExtension> {
                configureCommon()
            }
        }
    }
}

class KotlinLibraryJvmConvention : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("measure.kotlin.library")
            }

            extensions.configure<KotlinMultiplatformExtension> {
                configureJvm()
            }
        }
    }
}
class KotlinLibraryNativeConvention : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("measure.kotlin.library")
            }

            extensions.configure<KotlinMultiplatformExtension> {
                configureNative()
            }
        }
    }
}
