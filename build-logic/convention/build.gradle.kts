import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    `kotlin-dsl`
}

group = "io.github.john.tuesday.measurement.build-logic"

kotlin {
    jvmToolchain {
        languageVersion = JavaLanguageVersion.of(JavaVersion.VERSION_1_8.majorVersion)
    }
    compilerOptions {
        apiVersion = KotlinVersion.KOTLIN_1_9
        languageVersion = KotlinVersion.KOTLIN_1_9
        progressiveMode = true
        jvmTarget = JvmTarget.JVM_1_8
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
        val kotlinLibrary by registering {
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
