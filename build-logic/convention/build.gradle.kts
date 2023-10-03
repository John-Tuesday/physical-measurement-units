plugins {
    `kotlin-dsl`
}

group = "org.calamarfederal.measurement.build-logic"

kotlin {
    sourceSets.all {
        languageSettings.apply {
            languageVersion = "1.9"
            apiVersion = "1.9"
            progressiveMode = true
        }
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
    }
}