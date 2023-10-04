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

    override fun toString(): String = "${this::class.simpleName!!}(grams = $grams)"

    /**
     * Compare equality based on underlying mass value
     */
    override fun equals(other: Any?): Boolean = other is Mass && other.grams == grams
    override fun hashCode(): Int = grams.hashCode()

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

/**
 * Scale `this` by [number]
 */
operator fun Mass.times(number: Number): Mass = Mass(grams * number.toDouble())

/**
 * Shrink `this` by [number]
 */
operator fun Mass.div(number: Number): Mass = Mass(grams / number.toDouble())

val Number.micrograms: Mass get() = Mass(toDouble(), MassUnit.Microgram)
fun Mass.inMicrograms(): Double = inUnitsOf(MassUnit.Microgram)
val Number.milligrams: Mass get() = Mass(toDouble(), MassUnit.Milligram)
fun Mass.inMilligrams(): Double = inUnitsOf(MassUnit.Milligram)
val Number.grams: Mass get() = Mass(toDouble(), MassUnit.Gram)
fun Mass.inGrams(): Double = inUnitsOf(MassUnit.Gram)
val Number.kilograms: Mass get() = Mass(toDouble(), MassUnit.Kilogram)
fun Mass.inKilograms(): Double = inUnitsOf(MassUnit.Kilogram)
val Number.ounces: Mass get() = Mass(toDouble(), MassUnit.Ounce)
val Number.oz: Mass get() = ounces
fun Mass.inOunces(): Double = inUnitsOf(MassUnit.Ounce)
val Number.pounds: Mass get() = Mass(toDouble(), MassUnit.Pound)
val Number.lbs: Mass get() = pounds
fun Mass.inPounds(): Double = inUnitsOf(MassUnit.Pound)
