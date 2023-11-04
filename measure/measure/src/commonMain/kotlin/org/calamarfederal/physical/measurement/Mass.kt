package org.calamarfederal.physical.measurement

import kotlin.math.absoluteValue

/**
 * Measure of Mass
 *
 * (sometimes confused Weight)
 */
public class Mass internal constructor(
    internal val grams: Double,
) : Comparable<Mass> {
    override fun compareTo(other: Mass): Int = grams.compareTo(other.grams)

    override fun toString(): String = "${this::class.simpleName!!}(grams = $grams)"

    /**
     * Compare equality based on underlying mass value
     */
    override fun equals(other: Any?): Boolean = other is Mass && other.grams == grams
    override fun hashCode(): Int = grams.hashCode()

    public companion object
}

/**
 * Supported units of measure of [Mass]
 */
public enum class MassUnit(internal val toGramsScale: Double) {
    Microgram(0.000_001),
    Milligram(0.001),
    Gram(1.0),
    Kilogram(1_000.0),
    Ounce(28.349_523_125),
    Pound(453.592_37),
    ;
}

public fun Mass.inUnitsOf(massUnit: MassUnit): Double = grams / massUnit.toGramsScale

/**
 * Alternate constructor patter for [Mass]
 *
 * creates a [Mass] with [amount] number of [massUnit]
 */
public operator fun Mass.Companion.invoke(amount: Number, massUnit: MassUnit): Mass =
    Mass(grams = amount.toDouble() * massUnit.toGramsScale)

/**
 * Negate the underlying value
 */
public operator fun Mass.unaryMinus(): Mass = Mass(grams = -grams)
public val Mass.absoluteValue: Mass get() = Mass(grams = grams.absoluteValue)
public operator fun Mass.plus(other: Mass): Mass = Mass(grams = grams + other.grams)
public operator fun Mass.minus(other: Mass): Mass = Mass(grams = grams - other.grams)

/**
 * Ratio of `this` to [other]
 */
public operator fun Mass.div(other: Mass): Double = grams / other.grams

/**
 * Scale `this` by [number]
 */
public operator fun Mass.times(number: Number): Mass = Mass(grams * number.toDouble())

/**
 * Shrink `this` by [number]
 */
public operator fun Mass.div(number: Number): Mass = Mass(grams / number.toDouble())

public val Number.micrograms: Mass get() = Mass(toDouble(), MassUnit.Microgram)
public fun Mass.inMicrograms(): Double = inUnitsOf(MassUnit.Microgram)
public val Number.milligrams: Mass get() = Mass(toDouble(), MassUnit.Milligram)
public fun Mass.inMilligrams(): Double = inUnitsOf(MassUnit.Milligram)
public val Number.grams: Mass get() = Mass(toDouble(), MassUnit.Gram)
public fun Mass.inGrams(): Double = inUnitsOf(MassUnit.Gram)
public val Number.kilograms: Mass get() = Mass(toDouble(), MassUnit.Kilogram)
public fun Mass.inKilograms(): Double = inUnitsOf(MassUnit.Kilogram)
public val Number.ounces: Mass get() = Mass(toDouble(), MassUnit.Ounce)
public val Number.oz: Mass get() = ounces
public fun Mass.inOunces(): Double = inUnitsOf(MassUnit.Ounce)
public val Number.pounds: Mass get() = Mass(toDouble(), MassUnit.Pound)
public val Number.lbs: Mass get() = pounds
public fun Mass.inPounds(): Double = inUnitsOf(MassUnit.Pound)
