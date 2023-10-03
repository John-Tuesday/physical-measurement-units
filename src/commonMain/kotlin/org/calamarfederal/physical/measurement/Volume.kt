package org.calamarfederal.physical.measurement

import kotlin.math.absoluteValue

/**
 * Measure of Volume
 */
class Volume internal constructor(
    internal val liters: Double,
): Comparable<Volume> {
    override fun compareTo(other: Volume): Int = liters.compareTo(other.inUnitsOf(VolumeUnit.Liter))

    override fun toString(): String = "${this::class.simpleName!!}(liters = $liters)"

    /**
     * Compares equality based on the underlying volume value
     */
    override fun equals(other: Any?): Boolean = other is Volume && other.liters == liters
    override fun hashCode(): Int = liters.hashCode()

    companion object
}

/**
 * Supported units of measure for [Volume]
 */
enum class VolumeUnit(internal val toLiterScale: Double) {
    Milliliter(0.001),
    Liter(1.0),
    Kiloliter(1_000.0),
    UsGallon(3.785_411_784),
    UsFluidOunce(0.029_573_529_562_5),
    UsTablespoon(UsFluidOunce.toLiterScale / 2.0),
    UsTeaspoon(0.004_928_921_593_75),
    ;
}

fun Volume.inUnitsOf(volumeUnit: VolumeUnit): Double = liters / volumeUnit.toLiterScale

/**
 * Alternate constructor patter for [Volume]
 *
 * creates a [Volume] with [amount] number of [volumeUnit]
 */
operator fun Volume.Companion.invoke(amount: Number, volumeUnit: VolumeUnit): Volume =
    Volume(liters = amount.toDouble() * volumeUnit.toLiterScale)

/**
 * Negate the underlying value
 */
operator fun Volume.unaryMinus(): Volume = Volume(-liters)
val Volume.absoluteValue: Volume get() = Volume(liters.absoluteValue)
operator fun Volume.plus(other: Volume): Volume = Volume(liters + other.liters)
operator fun Volume.minus(other: Volume): Volume = Volume(liters + other.liters)

/**
 * Ratio of `this` to [other]
 */
operator fun Volume.div(other: Volume): Double = liters / other.liters

val Number.kiloliters: Volume get() = Volume(toDouble(), VolumeUnit.Kiloliter)
fun Volume.inKiloliters(): Double = inUnitsOf(VolumeUnit.Kiloliter)
val Number.liters: Volume get() = Volume(toDouble(), VolumeUnit.Liter)
fun Volume.inLiters(): Double = inUnitsOf(VolumeUnit.Liter)
val Number.milliliters: Volume get() = Volume(toDouble(), VolumeUnit.Milliliter)
fun Volume.inMilliliters(): Double = inUnitsOf(VolumeUnit.Milliliter)
val Number.usGallons: Volume get() = Volume(toDouble(), VolumeUnit.UsGallon)
fun Volume.inUsGallons(): Double = inUnitsOf(VolumeUnit.UsGallon)
val Number.usFluidOunces: Volume get() = Volume(toDouble(), VolumeUnit.UsFluidOunce)
val Number.usFlOz: Volume get() = usFluidOunces
fun Volume.inUsFluidOunce(): Double = inUnitsOf(VolumeUnit.UsFluidOunce)
val Number.usTablespoons: Volume get() = Volume(toDouble(), VolumeUnit.UsTablespoon)
fun Volume.inUsTablespoons(): Double = inUnitsOf(VolumeUnit.UsTablespoon)
val Number.usTeaspoons: Volume get() = Volume(toDouble(), VolumeUnit.UsTeaspoon)
fun Volume.inUsTeaspoons(): Double = inUnitsOf(VolumeUnit.UsTeaspoon)
