package org.calamarfederal.physical.measurement

import kotlin.math.absoluteValue

/**
 * Measure of Mass
 *
 * (sometimes confused Weight)
 */
class Mass internal constructor(
    internal val grams: Double,
) : Comparable<Mass> {
    override fun compareTo(other: Mass): Int = grams.compareTo(other.grams)

    companion object
}

/**
 * Supported units of measure of [Mass]
 */
enum class MassUnit(internal val toGramsScale: Double) {
    Microgram(0.000_001),
    Milligram(0.001),
    Gram(1.0),
    Kilogram(1_000.0),
    Ounce(28.349_523_125),
    Pound(453.592_37),
    ;
}

fun Mass.inUnitsOf(massUnit: MassUnit): Double = grams / massUnit.toGramsScale

/**
 * Alternate constructor patter for [Mass]
 *
 * creates a [Mass] with [amount] number of [massUnit]
 */
operator fun Mass.Companion.invoke(amount: Number, massUnit: MassUnit): Mass =
    Mass(grams = amount.toDouble() * massUnit.toGramsScale)

/**
 * Negate the underlying value
 */
operator fun Mass.unaryMinus(): Mass = Mass(grams = -grams)
val Mass.absoluteValue: Mass get() = Mass(grams = grams.absoluteValue)
operator fun Mass.plus(other: Mass): Mass = Mass(grams = grams + other.grams)
operator fun Mass.minus(other: Mass): Mass = Mass(grams = grams - other.grams)

/**
 * Ratio of `this` to [other]
 */
operator fun Mass.div(other: Mass): Double = grams / other.grams

val Number.micrograms: Mass get() = Mass(toDouble(), MassUnit.Microgram)
val Number.milligrams: Mass get() = Mass(toDouble(), MassUnit.Milligram)
val Number.grams: Mass get() = Mass(toDouble(), MassUnit.Gram)
val Number.kilograms: Mass get() = Mass(toDouble(), MassUnit.Kilogram)
val Number.oz: Mass get() = Mass(toDouble(), MassUnit.Ounce)
val Number.lbs: Mass get() = Mass(toDouble(), MassUnit.Pound)
