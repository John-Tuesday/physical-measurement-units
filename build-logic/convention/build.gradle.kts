import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    `kotlin-dsl`
}

group = "io.github.john.tuesday.measurement.build-logic"

kotlin {
    compilerOptions {
        apiVersion = KotlinVersion.KOTLIN_1_9
        languageVersion = KotlinVersion.KOTLIN_1_9
        progressiveMode = true
    }

    sourceSets {
        val main by getting {
            dependencies {
                compileOnly(libs.maven.assist.gradlePlugin)
                compileOnly(libs.kotlin.gradlePlugin)
                compileOnly(libs.kotlin.multiplatform.gradlePlugin)
            }
        }
    }
}

gradlePlugin {
    plugins {
        register("kotlinLibrary") {
            id = "measure.kotlin.library"
            implementationClass = "KotlinLibraryConvention"
        }
        val kotlinLibraryMultiplatform by registering {
            id = "measure.kotlin.library.multiplatform"
            implementationClass = "KotlinLibraryMultiplatformConvention"
        }

        val mavenConvention by registering {
            id = "measure.maven.publish"
            implementationClass = "MavenConvention"
        }
    }
}
