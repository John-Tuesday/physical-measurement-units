package org.calamarfederal.physical.measurement

import org.calamarfederal.physical.measurement.test.assertEquals
import kotlin.test.Test
import kotlin.test.assertEquals

class MassUnitTest {
    @Test
    fun metricIdentityTest() {
        fun check(expect: Mass, actual: Mass) {
            assertEquals(expect, actual)
            assertEquals(expect, actual.inKilograms().kilograms)
            assertEquals(expect, actual.inGrams().grams)
            assertEquals(expect, actual.inMilligrams().milligrams)
            assertEquals(expect, actual.inMicrograms().micrograms)
        }
        check(1.grams, 0.001.kilograms)
        check(1.grams, 1_000.milligrams)
        check(1.grams, 1_000_000.micrograms)
    }

    @Test
    fun usIdentityTest() {
        fun check(expect: Mass, actual: Mass) {
            assertEquals(expect, actual)
            assertEquals(expect, actual.inPounds().pounds)
            assertEquals(expect, actual.inOunces().ounces)
        }
        check(1.pounds, 16.ounces)
        check(1.ounces, 0.062_5.pounds)
    }

    @Test
    fun usToMetricTest() {
        assertEquals(1.pounds, 453.592_37.grams)
        assertEquals(1.ounces, 28.349_523_125.grams)
    }

    @Test
    fun plusMinusTest() {
        val amount = 1.grams
        val zero = 0.grams
        with(Mass) {
            assertEquals(zero, amount - amount)
            assertEquals(amount, amount + amount - amount)
            assertEquals(amount, -(-amount))
            assertEquals(zero, amount + (-amount))
        }
    }

    @Test
    fun scaleOperatorsTest() {
        with(Mass) {
            assertEquals(1.grams, 2.grams / 2)
            assertEquals(2.grams, 1.grams * 2)
        }
        assertEquals(1.00, 1.grams / 1.grams)
        assertEquals(2.00, 2.grams / 1.grams)
        assertEquals(0.50, 1.grams / 2.grams)
    }
}
