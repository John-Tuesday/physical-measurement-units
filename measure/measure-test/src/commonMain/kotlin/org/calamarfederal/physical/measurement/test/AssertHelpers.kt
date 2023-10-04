package org.calamarfederal.physical.measurement.test

import org.calamarfederal.physical.measurement.*
import kotlin.test.assertEquals
import kotlin.test.assertTrue

private const val DefaultTolerance = 0.000_000_001

fun Length.Companion.assertEquals(
    expected: Length,
    actual: Length,
    absoluteTolerance: Double = DefaultTolerance,
    message: String? = null
) = assertEquals(expected.inMeters(), actual.inMeters(), absoluteTolerance = absoluteTolerance, message = message)

fun Length.Companion.assertEquals(
    expected: Length,
    actual: Length,
    absoluteTolerance: Length,
    message: String? = null
) = assertTrue((expected - actual).absoluteValue <= absoluteTolerance.absoluteValue, message = message)

fun Mass.Companion.assertEquals(
    expected: Mass,
    actual: Mass,
    absoluteTolerance: Double = DefaultTolerance,
    message: String? = null
) = assertEquals(expected.inGrams(), actual.inGrams(), absoluteTolerance = absoluteTolerance, message = message)

fun Mass.Companion.assertEquals(
    expected: Mass,
    actual: Mass,
    absoluteTolerance: Mass,
    message: String? = null
) = assertTrue((expected - actual).absoluteValue <= absoluteTolerance.absoluteValue, message = message)
fun Volume.Companion.assertEquals(
    expected: Volume,
    actual: Volume,
    absoluteTolerance: Double = DefaultTolerance,
    message: String? = null
) = assertEquals(expected.inLiters(), actual.inLiters(), absoluteTolerance = absoluteTolerance, message = message)

fun Volume.Companion.assertEquals(
    expected: Volume,
    actual: Volume,
    absoluteTolerance: Volume,
    message: String? = null
) = assertTrue((expected - actual).absoluteValue <= absoluteTolerance.absoluteValue, message = message)

fun Energy.Companion.assertEquals(
    expected: Energy,
    actual: Energy,
    absoluteTolerance: Double = DefaultTolerance,
    message: String? = null
) = assertEquals(expected.inJoules(), actual.inJoules(), absoluteTolerance = absoluteTolerance, message = message)

fun Energy.Companion.assertEquals(
    expected: Energy,
    actual: Energy,
    absoluteTolerance: Energy,
    message: String? = null
) = assertTrue((expected - actual).absoluteValue <= absoluteTolerance.absoluteValue, message = message)
