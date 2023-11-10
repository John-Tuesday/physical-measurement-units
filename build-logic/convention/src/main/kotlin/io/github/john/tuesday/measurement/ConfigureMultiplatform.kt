package io.github.john.tuesday.measurement

import org.gradle.api.JavaVersion
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.kotlin.dsl.assign
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinTargetContainerWithPresetFunctions
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

internal fun KotlinProjectExtension.configureCommon(
    kotlinVersion: KotlinVersion = KotlinVersion.KOTLIN_1_9,
    javaVersion: JavaVersion = JavaVersion.VERSION_1_8,
) {
    sourceSets.configureEach {
        languageSettings {
            explicitApi()
            languageVersion = kotlinVersion.version
            apiVersion = kotlinVersion.version
            progressiveMode = true
        }
    }
    jvmToolchain {
        languageVersion = JavaLanguageVersion.of(javaVersion.majorVersion)
    }
}

/**
 * Configure the JVM target
 */
internal fun KotlinTargetContainerWithPresetFunctions.configureJvm() {
    jvm {
        withJava()
        testRuns.named("test") {
            executionTask.configure {
                useJUnitPlatform()
            }
        }
    }
}
