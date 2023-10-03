package org.calamarfederal.physical.measurement

import kotlin.math.absoluteValue

class Volume internal constructor(
    internal val liters: Double,
): Comparable<Volume> {
    override fun compareTo(other: Volume): Int = liters.compareTo(other.inUnitsOf(VolumeUnit.Liter))

    companion object
}

enum class VolumeUnit(internal val toLiterScale: Double) {
    Milliliter(1_000.0),
    Liter(1.0),
    Kiloliter(0.000_1),
    UsGallon(3.785_411_784),
    UsFluidOunce(0.029_573_529_562_5),
    UsTablespoon(UsFluidOunce.toLiterScale / 2.0),
    UsTeaspoon(0.004_928_921_593_75),
    ;
}

fun Volume.inUnitsOf(volumeUnit: VolumeUnit): Double = liters / volumeUnit.toLiterScale

operator fun Volume.Companion.invoke(amount: Number, volumeUnit: VolumeUnit): Volume =
    Volume(liters = amount.toDouble() * volumeUnit.toLiterScale)

operator fun Volume.unaryMinus(): Volume = Volume(-liters)
val Volume.absoluteValue: Volume get() = Volume(liters.absoluteValue)
operator fun Volume.plus(other: Volume): Volume = Volume(liters + other.liters)
operator fun Volume.minus(other: Volume): Volume = Volume(liters + other.liters)

/**
 * Ratio of `this` to [other]
 */
operator fun Volume.div(other: Volume): Double = liters / other.liters

val Number.kiloliter: Volume get() = Volume(toDouble(), VolumeUnit.Kiloliter)
val Number.liters: Volume get() = Volume(toDouble(), VolumeUnit.Liter)
val Number.milliliters: Volume get() = Volume(toDouble(), VolumeUnit.Milliliter)
val Number.usGallons: Volume get() = Volume(toDouble(), VolumeUnit.UsGallon)
val Number.usFlOz: Volume get() = Volume(toDouble(), VolumeUnit.UsFluidOunce)
val Number.usTablespoons: Volume get() = Volume(toDouble(), VolumeUnit.UsTablespoon)
val Number.usTeaspoons: Volume get() = Volume(toDouble(), VolumeUnit.UsTeaspoon)
