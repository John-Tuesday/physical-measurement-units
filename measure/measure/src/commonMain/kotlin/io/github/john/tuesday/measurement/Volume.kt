package io.github.john.tuesday.measurement

import kotlin.math.absoluteValue

/**
 * Measure of Volume
 */
public class Volume internal constructor(
    internal val liters: Double,
): Comparable<Volume> {
    /**
     * Compare using natural order
     */
    override fun compareTo(other: Volume): Int = liters.compareTo(other.inUnitsOf(VolumeUnit.Liter))

    /**
     * Returns string representation of the object
     */
    override fun toString(): String = "${this::class.simpleName!!}(liters = $liters)"

    /**
     * Compares equality based on the underlying volume value
     */
    override fun equals(other: Any?): Boolean = other is Volume && other.liters == liters

    /**
     * Returns hash code of this object
     */
    override fun hashCode(): Int = liters.hashCode()

    /**
     * Public companion object for extensibility
     */
    public companion object
}

/**
 * Supported units of measure for [Volume]
 */
public enum class VolumeUnit(internal val toLiterScale: Double) {
    Milliliter(0.001),
    Liter(1.0),
    Kiloliter(1_000.0),
    UsGallon(3.785_411_784),
    UsFluidOunce(0.029_573_529_562_5),
    UsTablespoon(UsFluidOunce.toLiterScale / 2.0),
    UsTeaspoon(0.004_928_921_593_75),
    ;
}

/**
 * Calculate the value in terms on [volumeUnit]
 */
public fun Volume.inUnitsOf(volumeUnit: VolumeUnit): Double = liters / volumeUnit.toLiterScale

/**
 * Creates a [Volume] with [amount] number of [volumeUnit]
 */
public fun Volume(amount: Number, volumeUnit: VolumeUnit): Volume =
    Volume(liters = amount.toDouble() * volumeUnit.toLiterScale)

/**
 * Negate the underlying value
 */
public operator fun Volume.unaryMinus(): Volume = Volume(liters = -liters)

/**
 * Returns the absolute value of this value
 */
public val Volume.absoluteValue: Volume get() = Volume(liters = liters.absoluteValue)

/**
 * Return a new [Volume] whose value is the sum of `this` and [other]
 */
public operator fun Volume.plus(other: Volume): Volume = Volume(liters = liters + other.liters)

/**
 * Return a new [Volume] whose value is the difference between `this` and [other]
 *
 *     this - other
 */
public operator fun Volume.minus(other: Volume): Volume = Volume(liters = liters - other.liters)

/**
 * Ratio of `this` to [other]
 */
public operator fun Volume.div(other: Volume): Double = liters / other.liters

/**
 * Scale `this` by [number]
 */
public operator fun Volume.times(number: Number): Volume = Volume(liters * number.toDouble())

/**
 * Shrink `this` by [number]
 */
public operator fun Volume.div(number: Number): Volume = Volume(liters / number.toDouble())

public val Number.kiloliters: Volume get() = Volume(toDouble(), VolumeUnit.Kiloliter)
public fun Volume.inKiloliters(): Double = inUnitsOf(VolumeUnit.Kiloliter)
public val Number.liters: Volume get() = Volume(toDouble(), VolumeUnit.Liter)
public fun Volume.inLiters(): Double = inUnitsOf(VolumeUnit.Liter)
public val Number.milliliters: Volume get() = Volume(toDouble(), VolumeUnit.Milliliter)
public fun Volume.inMilliliters(): Double = inUnitsOf(VolumeUnit.Milliliter)
public val Number.usGallons: Volume get() = Volume(toDouble(), VolumeUnit.UsGallon)
public fun Volume.inUsGallons(): Double = inUnitsOf(VolumeUnit.UsGallon)
public val Number.usFluidOunces: Volume get() = Volume(toDouble(), VolumeUnit.UsFluidOunce)
public val Number.usFlOz: Volume get() = usFluidOunces
public fun Volume.inUsFluidOunce(): Double = inUnitsOf(VolumeUnit.UsFluidOunce)
public val Number.usTablespoons: Volume get() = Volume(toDouble(), VolumeUnit.UsTablespoon)
public fun Volume.inUsTablespoons(): Double = inUnitsOf(VolumeUnit.UsTablespoon)
public val Number.usTeaspoons: Volume get() = Volume(toDouble(), VolumeUnit.UsTeaspoon)
public fun Volume.inUsTeaspoons(): Double = inUnitsOf(VolumeUnit.UsTeaspoon)
