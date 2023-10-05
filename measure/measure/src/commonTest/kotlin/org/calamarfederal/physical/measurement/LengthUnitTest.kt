package org.calamarfederal.physical.measurement

import org.calamarfederal.physical.measurement.test.assertEquals
import kotlin.test.Test
import kotlin.test.assertEquals

class LengthUnitTest {
    @Test
    fun metricIdentityTest() {
        fun check(expect: Length, actual: Length) {
            with(Length) {
                assertEquals(expect, actual)
                assertEquals(expect, actual.inKilometers().kilometers)
                assertEquals(expect, actual.inMeters().meters)
                assertEquals(expect, actual.inCentimeters().centimeters)
                assertEquals(expect, actual.inMillimeters().millimeters)
            }
        }
        check(1.meters, 0.001.kilometers)
        check(1.meters, 100.centimeters)
        check(1.meters, 1_000.millimeters)
    }

    @Test
    fun usIdentityTest() {
        fun check(expect: Length, actual: Length, message: String = "") {
            with(Length) {
                assertEquals(expect, actual, message = "$message direct compare")
                assertEquals(expect, actual.inMiles().miles, message = "$message miles")
                assertEquals(expect, actual.inFeet().feet, message = "$message feet")
                assertEquals(expect, actual.inInches().inches, message = "$message inches")
            }
        }
        check(1.feet, 12.inches)
        check(1.miles, 5280.feet)
    }

    @Test
    fun usToMetricTest() {
        with(Length) {
            assertEquals(1.inches, 0.025_4.meters)
            assertEquals(1.feet, 0.304_8.meters)
            assertEquals(1.miles, 1_609.344.meters)
        }
    }

    @Test
    fun plusMinusTest() {
        val amount = 1.meters
        val zero = 0.meters
        with(Length) {
            assertEquals(zero, amount - amount)
            assertEquals(amount, amount + amount - amount)
            assertEquals(amount, -(-amount))
            assertEquals(zero, amount + (-amount))
        }
    }

    @Test
    fun scaleOperatorsTest() {
        with(Length) {
            assertEquals(1.meters, 2.meters / 2)
            assertEquals(2.meters, 1.meters * 2)
        }
        assertEquals( 1.00, 1.meters / 1.meters)
        assertEquals(2.00, 2.meters / 1.meters)
        assertEquals(0.50, 1.meters / 2.meters)
    }
}
