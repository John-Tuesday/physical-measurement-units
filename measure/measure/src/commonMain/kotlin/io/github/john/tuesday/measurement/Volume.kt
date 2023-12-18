package io.github.john.tuesday.measurement

import kotlin.jvm.JvmInline
import kotlin.math.absoluteValue

/**
 * Measure of Volume
 */
@JvmInline
public value class Volume internal constructor(
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
     * Public companion object for extensibility
     */
    public companion object
}

/**
 * Supported units of measure for [Volume]
 */
public enum class VolumeUnit(internal val toLiterScale: Double) {
    /**
     * Unit of measure for [Volume]
     */
    Milliliter(0.001),

    /**
     * Unit of measure for [Volume]
     */
    Liter(1.0),

    /**
     * Unit of measure for [Volume]
     */
    Kiloliter(1_000.0),

    /**
     * Unit of measure for [Volume]
     */
    UsGallon(3.785_411_784),

    /**
     * Unit of measure for [Volume]
     */
    UsFluidOunce(0.029_573_529_562_5),

    /**
     * Unit of measure for [Volume]
     */
    UsTablespoon(UsFluidOunce.toLiterScale / 2.0),

    /**
     * Unit of measure for [Volume]
     */
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

/**
 * Returns a [Volume] equal to `this` number of kiloliters
 */
public val Number.kiloliters: Volume get() = Volume(toDouble(), VolumeUnit.Kiloliter)

/**
 * Value of `this` [Volume] as a [Double] in units of kiloliters
 */
public fun Volume.inKiloliters(): Double = inUnitsOf(VolumeUnit.Kiloliter)

/**
 * Returns a [Volume] equal to `this` number of liters
 */
public val Number.liters: Volume get() = Volume(toDouble(), VolumeUnit.Liter)

/**
 * Value of `this` [Volume] as a [Double] in units of liters
 */
public fun Volume.inLiters(): Double = inUnitsOf(VolumeUnit.Liter)

/**
 * Returns a [Volume] equal to `this` number of milliliters
 */
public val Number.milliliters: Volume get() = Volume(toDouble(), VolumeUnit.Milliliter)

/**
 * Value of `this` [Volume] as a [Double] in units of milliliters
 */
public fun Volume.inMilliliters(): Double = inUnitsOf(VolumeUnit.Milliliter)

/**
 * Returns a [Volume] equal to `this` number of US gallons
 */
public val Number.usGallons: Volume get() = Volume(toDouble(), VolumeUnit.UsGallon)

/**
 * Value of `this` [Volume] as a [Double] in units of US gallons
 */
public fun Volume.inUsGallons(): Double = inUnitsOf(VolumeUnit.UsGallon)

/**
 * Returns a [Volume] equal to `this` number of US fluid ounces
 */
public val Number.usFluidOunces: Volume get() = Volume(toDouble(), VolumeUnit.UsFluidOunce)

/**
 * Returns a [Volume] equal to `this` number of US fluid ounces
 */
public val Number.usFlOz: Volume get() = usFluidOunces

/**
 * Value of `this` [Volume] as a [Double] in units of US fluid ounces
 */
public fun Volume.inUsFluidOunce(): Double = inUnitsOf(VolumeUnit.UsFluidOunce)

/**
 * Returns a [Volume] equal to `this` number of US tablespoons
 */
public val Number.usTablespoons: Volume get() = Volume(toDouble(), VolumeUnit.UsTablespoon)

/**
 * Value of `this` [Volume] as a [Double] in units of US tablespoons
 */
public fun Volume.inUsTablespoons(): Double = inUnitsOf(VolumeUnit.UsTablespoon)

/**
 * Returns a [Volume] equal to `this` number of US teaspoons
 */
public val Number.usTeaspoons: Volume get() = Volume(toDouble(), VolumeUnit.UsTeaspoon)

/**
 * Value of `this` [Volume] as a [Double] in units of US teaspoons
 */
public fun Volume.inUsTeaspoons(): Double = inUnitsOf(VolumeUnit.UsTeaspoon)
