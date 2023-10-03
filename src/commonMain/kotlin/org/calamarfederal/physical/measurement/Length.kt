package org.calamarfederal.physical.measurement

import kotlin.math.absoluteValue

class Length internal constructor(
    internal val meter: Double,
): Comparable<Length> {
    override fun compareTo(other: Length): Int = meter.compareTo(other.meter)

    companion object
}

enum class LengthUnit(internal val toMeterScale: Double) {
    Millimeter(0.001),
    Centimeter(0.01),
    Meter(1.0),
    Kilometer(1_000.0),
    Mile(1_609.344),
    Feet(0.304_8),
    Inch(0.025_4),
    ;
}

fun Length.inUnitsOf(lengthUnit: LengthUnit): Double = meter / lengthUnit.toMeterScale

operator fun Length.Companion.invoke(amount: Number, lengthUnit: LengthUnit): Length =
    Length(meter = amount.toDouble() * lengthUnit.toMeterScale)

operator fun Length.unaryMinus(): Length = Length(meter = -meter)
val Length.absoluteValue: Length get() = Length(meter = meter.absoluteValue)
operator fun Length.plus(other: Length): Length = Length(meter = meter + other.meter)
operator fun Length.minus(other: Length): Length = Length(meter = meter - other.meter)

/**
 * Ratio of `this` to [other]
 */
operator fun Length.div(other: Length): Double = meter / other.meter


val Number.kilometers: Length get() = Length(toDouble(), LengthUnit.Kilometer)
val Number.meters: Length get() = Length(toDouble(), LengthUnit.Meter)
val Number.centimeters: Length get() = Length(toDouble(), LengthUnit.Centimeter)
val Number.millimeters: Length get() = Length(toDouble(), LengthUnit.Millimeter)
val Number.miles: Length get() = Length(toDouble(), LengthUnit.Mile)
val Number.feet: Length get() = Length(toDouble(), LengthUnit.Feet)
val Number.inches: Length get() = Length(toDouble(), LengthUnit.Inch)
