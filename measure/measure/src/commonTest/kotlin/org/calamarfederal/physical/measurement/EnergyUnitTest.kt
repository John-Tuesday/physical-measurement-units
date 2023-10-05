package org.calamarfederal.physical.measurement

import org.calamarfederal.physical.measurement.test.assertEquals
import kotlin.test.Test
import kotlin.test.assertEquals

class EnergyUnitTest {
    @Test
    fun jouleIdentityTest() {
        fun check(expect: Energy, actual: Energy) {
            with(Energy) {
                assertEquals(expect, actual)
                assertEquals(expect, actual.inJoules().joules)
                assertEquals(expect, actual.inKilojoules().kilojoules)
                assertEquals(expect, actual.inMegajoules().megajoules)
            }
        }
        check(1.joules, 0.001.kilojoules)
        check(1.joules, 0.000_001.megajoules)
    }

    @Test
    fun calorieIdentityTest() {
        fun check(expect: Energy, actual: Energy) {
            with(Energy) {
                assertEquals(expect, actual)
                assertEquals(expect, actual.inCalories().calories)
                assertEquals(expect, actual.inKilocalories().kilocalories)
            }
        }
        check(1.calories, 0.001.kilocalories)
    }

    @Test
    fun calorieToJouleIdentityTest() {
        with(Energy) {
            assertEquals(1.calories, 4.184.joules)
            assertEquals(1.kilocalories, 4184.joules)
        }
    }

    @Test
    fun plusMinusTest() {
        val amount = 1.joules
        val zero = 0.joules
        with(Length) {
            assertEquals(zero, amount - amount)
            assertEquals(amount, amount + amount - amount)
            assertEquals(amount, -(-amount))
            assertEquals(zero, amount + (-amount))
        }
    }

    @Test
    fun scaleOperatorsTest() {
        with(Energy) {
            assertEquals(1.joules, 2.joules / 2)
            assertEquals(2.joules, 2.joules / 1)
            assertEquals(2.joules, 1.joules * 2)
            assertEquals(2.joules, 2.joules * 1)
        }
        assertEquals(1.00, 1.joules / 1.joules)
        assertEquals(2.00, 2.joules / 1.joules)
        assertEquals(0.50, 1.joules / 2.joules)
    }
}
