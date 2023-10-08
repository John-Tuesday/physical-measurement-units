import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    `kotlin-dsl`
}

group = "org.calamarfederal.measurement.build-logic"

kotlin {
    compilerOptions {
        apiVersion = KotlinVersion.KOTLIN_1_9
        languageVersion = KotlinVersion.KOTLIN_1_9
        progressiveMode = true
    }
}

dependencies {
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.kotlin.multiplatform.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("kotlinLibrary") {
            id = "measure.kotlin.library"
            implementationClass = "KotlinLibraryConvention"
        }
        register("kotlinLibraryJvm") {
            id = "measure.kotlin.library.jvm"
            implementationClass = "KotlinLibraryJvmConvention"
        }
        register("kotlinLibraryNative") {
            id = "measure.kotlin.library.native"
            implementationClass = "KotlinLibraryNativeConvention"
        }

        register("mavenPublication") {
            id = "measure.maven.publication"
            implementationClass = "MavenPublicationConvention"
        }
    }
}
