package org.calamarfederal.physical.measurement

import kotlin.math.absoluteValue

/**
 * Measure of Length
 */
public class Length internal constructor(
    internal val meter: Double,
): Comparable<Length> {
    override fun compareTo(other: Length): Int = meter.compareTo(other.meter)

    override fun toString(): String = "${this::class.simpleName!!}(meter = $meter)"
    /**
     * Compares equality based on the underlying length value
     */
    override fun equals(other: Any?): Boolean = other is Length && other.meter == meter
    override fun hashCode(): Int = meter.hashCode()

    public companion object
}

/**
 * Supported measurement units of [Length]
 */
public enum class LengthUnit(internal val toMeterScale: Double) {
    Millimeter(0.001),
    Centimeter(0.01),
    Meter(1.0),
    Kilometer(1_000.0),
    Mile(1_609.344),
    Foot(0.304_8),
    Inch(0.025_4),
    ;
}

public fun Length.inUnitsOf(lengthUnit: LengthUnit): Double = meter / lengthUnit.toMeterScale

/**
 * Alternate constructor patter for [Length]
 *
 * creates a [Length] with [amount] number of [lengthUnit]
 */
public operator fun Length.Companion.invoke(amount: Number, lengthUnit: LengthUnit): Length =
    Length(meter = amount.toDouble() * lengthUnit.toMeterScale)

/**
 * Negate the underlying value
 */
public operator fun Length.unaryMinus(): Length = Length(meter = -meter)

public val Length.absoluteValue: Length get() = Length(meter = meter.absoluteValue)
public operator fun Length.plus(other: Length): Length = Length(meter = meter + other.meter)
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


public val Number.kilometers: Length get() = Length(toDouble(), LengthUnit.Kilometer)
public fun Length.inKilometers(): Double = inUnitsOf(LengthUnit.Kilometer)
public val Number.meters: Length get() = Length(toDouble(), LengthUnit.Meter)
public fun Length.inMeters(): Double = inUnitsOf(LengthUnit.Meter)
public val Number.centimeters: Length get() = Length(toDouble(), LengthUnit.Centimeter)
public fun Length.inCentimeters(): Double = inUnitsOf(LengthUnit.Centimeter)
public val Number.millimeters: Length get() = Length(toDouble(), LengthUnit.Millimeter)
public fun Length.inMillimeters(): Double = inUnitsOf(LengthUnit.Millimeter)
public val Number.miles: Length get() = Length(toDouble(), LengthUnit.Mile)
public fun Length.inMiles(): Double = inUnitsOf(LengthUnit.Mile)
public val Number.feet: Length get() = Length(toDouble(), LengthUnit.Foot)
public fun Length.inFeet(): Double = inUnitsOf(LengthUnit.Foot)
public val Number.inches: Length get() = Length(toDouble(), LengthUnit.Inch)
public fun Length.inInches(): Double = inUnitsOf(LengthUnit.Inch)
