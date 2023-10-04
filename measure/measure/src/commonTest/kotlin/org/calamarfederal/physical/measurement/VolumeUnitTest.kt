package org.calamarfederal.physical.measurement

import org.calamarfederal.physical.measurement.test.assertEquals
import kotlin.test.Test
import kotlin.test.assertEquals

class VolumeUnitTest {
    @Test
    fun metricIdentityTest() {
        fun check(expect: Volume, actual: Volume) {
            assertEquals(expect, actual)
            assertEquals(expect.inKiloliters(), actual.inKiloliters())
            assertEquals(expect, actual.inKiloliters().kiloliters)
            assertEquals(expect.inLiters(), actual.inLiters())
            assertEquals(expect, actual.inLiters().liters)
            assertEquals(expect.inMilliliters(), actual.inMilliliters())
            assertEquals(expect, actual.inMilliliters().milliliters)
        }
        check(1.liters, 1_000.milliliters)
        check(1.liters, 0.001.kiloliters)
    }

    @Test
    fun usIdentityTest() {
        fun check(expect: Volume, actual: Volume) {
            assertEquals(expect, actual, "Equals compare")
            assertEquals(expect, actual.inUsGallons().usGallons, "US Gallons")
            assertEquals(expect, actual.inUsFluidOunce().usFluidOunces, "US Fluid oz")
            assertEquals(expect, actual.inUsTablespoons().usTablespoons, "US Tablespoons")
            assertEquals(expect, actual.inUsTeaspoons().usTeaspoons, "US Teaspoons")
        }
        check(1.usGallons, 128.usFluidOunces)
        check(1.usGallons, 256.usTablespoons)
        check(1.usGallons, 768.usTeaspoons)
    }

    @Test
    fun usToMetricIdentityTest() {
        assertEquals(1.usGallons, 3.785_411_784.liters)
        assertEquals(1.usFlOz, 0.029_573_529_562_5.liters)
        assertEquals(1.usTeaspoons, 0.004_928_921_593_75.liters)
        assertEquals(1.usTablespoons, 0.014_786_764_781_25.liters)
    }

    @Test
    fun scaleOperatorsTest() {
        with(Volume) {
            assertEquals(1.liters, 2.liters / 2)
            assertEquals(2.liters, 1.liters * 2)
        }
        assertEquals(1.00, 1.liters / 1.liters)
        assertEquals(2.00, 2.liters / 1.liters)
        assertEquals(0.50, 1.liters / 2.liters)
    }
}
