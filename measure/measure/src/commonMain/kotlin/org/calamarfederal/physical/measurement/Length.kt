package org.calamarfederal.physical.measurement

import kotlin.math.absoluteValue

/**
 * Measure of Length
 */
class Length internal constructor(
    internal val meter: Double,
): Comparable<Length> {
    override fun compareTo(other: Length): Int = meter.compareTo(other.meter)

    override fun toString(): String = "${this::class.simpleName!!}(meter = $meter)"
    /**
     * Compares equality based on the underlying length value
     */
    override fun equals(other: Any?): Boolean = other is Length && other.meter == meter
    override fun hashCode(): Int = meter.hashCode()

    companion object
}

/**
 * Supported measurement units of [Length]
 */
enum class LengthUnit(internal val toMeterScale: Double) {
    Millimeter(0.001),
    Centimeter(0.01),
    Meter(1.0),
    Kilometer(1_000.0),
    Mile(1_609.344),
    Foot(0.304_8),
    Inch(0.025_4),
    ;
}

fun Length.inUnitsOf(lengthUnit: LengthUnit): Double = meter / lengthUnit.toMeterScale

/**
 * Alternate constructor patter for [Length]
 *
 * creates a [Length] with [amount] number of [lengthUnit]
 */
operator fun Length.Companion.invoke(amount: Number, lengthUnit: LengthUnit): Length =
    Length(meter = amount.toDouble() * lengthUnit.toMeterScale)

/**
 * Negate the underlying value
 */
operator fun Length.unaryMinus(): Length = Length(meter = -meter)

val Length.absoluteValue: Length get() = Length(meter = meter.absoluteValue)
operator fun Length.plus(other: Length): Length = Length(meter = meter + other.meter)
operator fun Length.minus(other: Length): Length = Length(meter = meter - other.meter)

/**
 * Ratio of `this` to [other]
 */
operator fun Length.div(other: Length): Double = meter / other.meter


val Number.kilometers: Length get() = Length(toDouble(), LengthUnit.Kilometer)
fun Length.inKilometers(): Double = inUnitsOf(LengthUnit.Kilometer)
val Number.meters: Length get() = Length(toDouble(), LengthUnit.Meter)
fun Length.inMeters(): Double = inUnitsOf(LengthUnit.Meter)
val Number.centimeters: Length get() = Length(toDouble(), LengthUnit.Centimeter)
fun Length.inCentimeters(): Double = inUnitsOf(LengthUnit.Centimeter)
val Number.millimeters: Length get() = Length(toDouble(), LengthUnit.Millimeter)
fun Length.inMillimeters(): Double = inUnitsOf(LengthUnit.Millimeter)
val Number.miles: Length get() = Length(toDouble(), LengthUnit.Mile)
fun Length.inMiles(): Double = inUnitsOf(LengthUnit.Mile)
val Number.feet: Length get() = Length(toDouble(), LengthUnit.Foot)
fun Length.inFeet(): Double = inUnitsOf(LengthUnit.Foot)
val Number.inches: Length get() = Length(toDouble(), LengthUnit.Inch)
fun Length.inInches(): Double = inUnitsOf(LengthUnit.Inch)
