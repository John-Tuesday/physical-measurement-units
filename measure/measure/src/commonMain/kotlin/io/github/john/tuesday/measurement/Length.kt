package io.github.john.tuesday.measurement

import kotlin.jvm.JvmInline
import kotlin.math.absoluteValue

/**
 * Measure of Length
 */
@JvmInline
public value class Length internal constructor(
    internal val meter: Double,
): Comparable<Length> {
    /**
     * Compare using natural order
     */
    override fun compareTo(other: Length): Int = meter.compareTo(other.meter)

    /**
     * Returns string representation of the object
     */
    override fun toString(): String = "${this::class.simpleName!!}(meter = $meter)"

    /**
     * Public companion object for extensibility
     */
    public companion object
}

/**
 * Supported measurement units of [Length]
 */
public enum class LengthUnit(internal val toMeterScale: Double) {
    /**
     * Unit of measure for [Length]
     */
    Millimeter(0.001),

    /**
     * Unit of measure for [Length]
     */
    Centimeter(0.01),

    /**
     * Unit of measure for [Length]
     */
    Meter(1.0),

    /**
     * Unit of measure for [Length]
     */
    Kilometer(1_000.0),

    /**
     * Unit of measure for [Length]
     */
    Mile(1_609.344),

    /**
     * Unit of measure for [Length]
     */
    Foot(0.304_8),

    /**
     * Unit of measure for [Length]
     */
    Inch(0.025_4),
    ;
}

/**
 * Calculate the value in terms of [lengthUnit]
 */
public fun Length.inUnitsOf(lengthUnit: LengthUnit): Double = meter / lengthUnit.toMeterScale

/**
 * Creates a [Length] with [amount] number of [lengthUnit]
 */
public fun Length(amount: Number, lengthUnit: LengthUnit): Length =
    Length(meter = amount.toDouble() * lengthUnit.toMeterScale)

/**
 * Negate the underlying value
 */
public operator fun Length.unaryMinus(): Length = Length(meter = -meter)

/**
 * Returns the absolute value of this value
 */
public val Length.absoluteValue: Length get() = Length(meter = meter.absoluteValue)

/**
 * Returns a new [Length] with the sum of `this` and [other]
 */
public operator fun Length.plus(other: Length): Length = Length(meter = meter + other.meter)

/**
 * Returns a new [Length] with the difference between `this` and [other]
 *
 *     this - other
 */
public operator fun Length.minus(other: Length): Length = Length(meter = meter - other.meter)

/**
 * Ratio of `this` to [other]
 */
public operator fun Length.div(other: Length): Double = meter / other.meter

/**
 * Scale `this` by [number]
 */
public operator fun Length.times(number: Number): Length = Length(meter * number.toDouble())

/**
 * Shrink `this` by [number]
 */
public operator fun Length.div(number: Number): Length = Length(meter / number.toDouble())

/**
 * Return a [Length] equal to `this` number of kilometers
 */
public val Number.kilometers: Length get() = Length(toDouble(), LengthUnit.Kilometer)

/**
 * Value of `this` [Length] as a [Double] in units of kilometer
 */
public fun Length.inKilometers(): Double = inUnitsOf(LengthUnit.Kilometer)

/**
 * Return a [Length] equal to `this` number of meters
 */
public val Number.meters: Length get() = Length(toDouble(), LengthUnit.Meter)

/**
 * Value of `this` [Length] as a [Double] in units of kilometer
 */
public fun Length.inMeters(): Double = inUnitsOf(LengthUnit.Meter)

/**
 * Return a [Length] equal to `this` number of centimeters
 */
public val Number.centimeters: Length get() = Length(toDouble(), LengthUnit.Centimeter)

/**
 * Value of `this` [Length] as a [Double] in units of kilometer
 */
public fun Length.inCentimeters(): Double = inUnitsOf(LengthUnit.Centimeter)

/**
 * Return a [Length] equal to `this` number of millimeters
 */
public val Number.millimeters: Length get() = Length(toDouble(), LengthUnit.Millimeter)

/**
 * Value of `this` [Length] as a [Double] in units of kilometer
 */
public fun Length.inMillimeters(): Double = inUnitsOf(LengthUnit.Millimeter)

/**
 * Return a [Length] equal to `this` number of miles
 */
public val Number.miles: Length get() = Length(toDouble(), LengthUnit.Mile)

/**
 * Value of `this` [Length] as a [Double] in units of kilometer
 */
public fun Length.inMiles(): Double = inUnitsOf(LengthUnit.Mile)

/**
 * Return a [Length] equal to `this` number of feet
 */
public val Number.feet: Length get() = Length(toDouble(), LengthUnit.Foot)

/**
 * Value of `this` [Length] as a [Double] in units of kilometer
 */
public fun Length.inFeet(): Double = inUnitsOf(LengthUnit.Foot)

/**
 * Return a [Length] equal to `this` number of inches
 */
public val Number.inches: Length get() = Length(toDouble(), LengthUnit.Inch)

/**
 * Value of `this` [Length] as a [Double] in units of kilometer
 */
public fun Length.inInches(): Double = inUnitsOf(LengthUnit.Inch)
