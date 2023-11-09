package io.github.john.tuesday.measurement.test

import io.github.john.tuesday.measurement.*
import kotlin.test.assertEquals
import kotlin.test.assertTrue

private const val DefaultTolerance = 0.000_000_001

/**
 * Asserts the difference between [actual] and [expected] is within [absoluteTolerance] with optional [message]
 */
public fun Length.Companion.assertEquals(
    expected: Length,
    actual: Length,
    absoluteTolerance: Double = DefaultTolerance,
    message: String? = null
): Unit = assertEquals(expected.inMeters(), actual.inMeters(), absoluteTolerance = absoluteTolerance, message = message)

/**
 * Asserts the difference between [actual] and [expected] is within [absoluteTolerance] with optional [message]
 */
public fun Length.Companion.assertEquals(
    expected: Length,
    actual: Length,
    absoluteTolerance: Length,
    message: String? = null
): Unit = assertTrue((expected - actual).absoluteValue <= absoluteTolerance.absoluteValue, message = message)

/**
 * Asserts the difference between [actual] and [expected] is within [absoluteTolerance] with optional [message]
 */
public fun Mass.Companion.assertEquals(
    expected: Mass,
    actual: Mass,
    absoluteTolerance: Double = DefaultTolerance,
    message: String? = null
): Unit = assertEquals(expected.inGrams(), actual.inGrams(), absoluteTolerance = absoluteTolerance, message = message)

/**
 * Asserts the difference between [actual] and [expected] is within [absoluteTolerance] with optional [message]
 */
public fun Mass.Companion.assertEquals(
    expected: Mass,
    actual: Mass,
    absoluteTolerance: Mass,
    message: String? = null
): Unit = assertTrue((expected - actual).absoluteValue <= absoluteTolerance.absoluteValue, message = message)

/**
 * Asserts the difference between [actual] and [expected] is within [absoluteTolerance] with optional [message]
 */
public fun Volume.Companion.assertEquals(
    expected: Volume,
    actual: Volume,
    absoluteTolerance: Double = DefaultTolerance,
    message: String? = null
): Unit = assertEquals(expected.inLiters(), actual.inLiters(), absoluteTolerance = absoluteTolerance, message = message)

/**
 * Asserts the difference between [actual] and [expected] is within [absoluteTolerance] with optional [message]
 */
public fun Volume.Companion.assertEquals(
    expected: Volume,
    actual: Volume,
    absoluteTolerance: Volume,
    message: String? = null
): Unit = assertTrue((expected - actual).absoluteValue <= absoluteTolerance.absoluteValue, message = message)

/**
 * Asserts the difference between [actual] and [expected] is within [absoluteTolerance] with optional [message]
 */
public fun Energy.Companion.assertEquals(
    expected: Energy,
    actual: Energy,
    absoluteTolerance: Double = DefaultTolerance,
    message: String? = null
): Unit = assertEquals(expected.inJoules(), actual.inJoules(), absoluteTolerance = absoluteTolerance, message = message)

/**
 * Asserts the difference between [actual] and [expected] is within [absoluteTolerance] with optional [message]
 */
public fun Energy.Companion.assertEquals(
    expected: Energy,
    actual: Energy,
    absoluteTolerance: Energy,
    message: String? = null
): Unit = assertTrue((expected - actual).absoluteValue <= absoluteTolerance.absoluteValue, message = message)
