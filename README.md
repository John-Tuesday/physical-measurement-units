# physical-measurement-units

[![Release](https://img.shields.io/maven-central/v/io.github.john-tuesday/measure?logo=Sonatype&labelColor=white&logoColor=black&style=flat-square)](https://central.sonatype.com/search?q=measure&namespace=io.github.john-tuesday)
![multiplatform](https://img.shields.io/badge/kotlin-multiplatform-7F52FF?logo=Kotlin&labelColor=white&style=flat-square)
[![License](https://img.shields.io/github/license/John-Tuesday/physical-measurement-units?logo=Open-Source-Initiative&labelColor=white&style=flat-square)](LICENSE)

Simple Kotlin Multiplatform library which supports different types of units of measure and

## Getting started

First, add a dependency to this library.

<details>

<summary>Gradle (Kotlin DSL)</summary>

```kotlin
// build.gradle.kts

dependencies {
    implementation("io.github.john-tuesday:measure:$version")

    // Optional, adds test fixtures
    testImplementation("io.github.john-tuesday:measure-test:$version")
}
```

</details>

Now, use the library!

```kotlin
val quarterGrams: Mass = 5.67.grams
val quarterOz: Mass = 0.2.ounces
val twoQuarters = quarterGrams + quarterOz
```

## Unit types

* Energy
* Length
* Mass
* Volume

## Documentation

Generated api documentation can be
found [here](https://john-tuesday.github.io/physical-measurement-units/documentation/), and notes on conventions can be
found [here](CONVENTION.md).
