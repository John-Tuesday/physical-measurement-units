package io.github.john.tuesday.measurement

import kotlin.math.absoluteValue

/**
 * Measure of Mass
 *
 * (sometimes confused Weight)
 */
public class Mass internal constructor(
    internal val grams: Double,
) : Comparable<Mass> {
    /**
     * Compare using natural order
     */
    override fun compareTo(other: Mass): Int = grams.compareTo(other.grams)

    /**
     * Returns string representation of the object
     */
    override fun toString(): String = "${this::class.simpleName!!}(grams = $grams)"

    /**
     * Compare equality based on underlying mass value
     */
    override fun equals(other: Any?): Boolean = other is Mass && other.grams == grams

    /**
     * Returns hash code of this object
     */
    override fun hashCode(): Int = grams.hashCode()

    /**
     * Public companion object for extensibility
     */
    public companion object
}

/**
 * Supported units of measure of [Mass]
 */
public enum class MassUnit(internal val toGramsScale: Double) {
    /**
     * Unit of measure for [Mass]
     */
    Microgram(0.000_001),

    /**
     * Unit of measure for [Mass]
     */
    Milligram(0.001),

    /**
     * Unit of measure for [Mass]
     */
    Gram(1.0),

    /**
     * Unit of measure for [Mass]
     */
    Kilogram(1_000.0),

    /**
     * Unit of measure for [Mass]
     */
    Ounce(28.349_523_125),

    /**
     * Unit of measure for [Mass]
     */
    Pound(453.592_37),
    ;
}

/**
 * Calculate the value in terms on [massUnit]
 */
public fun Mass.inUnitsOf(massUnit: MassUnit): Double = grams / massUnit.toGramsScale

/**
 * Alternate constructor patter for [Mass]
 *
 * creates a [Mass] with [amount] number of [massUnit]
 */
public fun Mass(amount: Number, massUnit: MassUnit): Mass =
    Mass(grams = amount.toDouble() * massUnit.toGramsScale)

/**
 * Negate the underlying value
 */
public operator fun Mass.unaryMinus(): Mass = Mass(grams = -grams)

/**
 * Returns the absolute value of this value
 */
public val Mass.absoluteValue: Mass get() = Mass(grams = grams.absoluteValue)

/**
 * Returns a new [Mass] with the sum of `this` and [other]
 */
public operator fun Mass.plus(other: Mass): Mass = Mass(grams = grams + other.grams)

/**
 * Returns a new [Mass] with the difference between `this` and [other]
 *
 *     this - other
 */
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

/**
 * Returns a [Mass] equal to `this` number of micrograms
 */
public val Number.micrograms: Mass get() = Mass(toDouble(), MassUnit.Microgram)

/**
 * Values of `this` [Mass] as a [Double] in units of micrograms
 */
public fun Mass.inMicrograms(): Double = inUnitsOf(MassUnit.Microgram)

/**
 * Returns a [Mass] equal to `this` number of milligrams
 */
public val Number.milligrams: Mass get() = Mass(toDouble(), MassUnit.Milligram)

/**
 * Values of `this` [Mass] as a [Double] in units of milligrams
 */
public fun Mass.inMilligrams(): Double = inUnitsOf(MassUnit.Milligram)

/**
 * Returns a [Mass] equal to `this` number of grams
 */
public val Number.grams: Mass get() = Mass(toDouble(), MassUnit.Gram)

/**
 * Values of `this` [Mass] as a [Double] in units of grams
 */
public fun Mass.inGrams(): Double = inUnitsOf(MassUnit.Gram)

/**
 * Returns a [Mass] equal to `this` number of kilograms
 */
public val Number.kilograms: Mass get() = Mass(toDouble(), MassUnit.Kilogram)

/**
 * Values of `this` [Mass] as a [Double] in units of kilograms
 */
public fun Mass.inKilograms(): Double = inUnitsOf(MassUnit.Kilogram)

/**
 * Returns a [Mass] equal to `this` number of ounces
 */
public val Number.ounces: Mass get() = Mass(toDouble(), MassUnit.Ounce)

/**
 * Returns a [Mass] equal to `this` number of ounces
 */
public val Number.oz: Mass get() = ounces

/**
 * Values of `this` [Mass] as a [Double] in units of ounces
 */
public fun Mass.inOunces(): Double = inUnitsOf(MassUnit.Ounce)

/**
 * Returns a [Mass] equal to `this` number of pounds
 */
public val Number.pounds: Mass get() = Mass(toDouble(), MassUnit.Pound)

/**
 * Returns a [Mass] equal to `this` number of pounds
 */
public val Number.lbs: Mass get() = pounds

/**
 * Values of `this` [Mass] as a [Double] in units of pounds
 */
public fun Mass.inPounds(): Double = inUnitsOf(MassUnit.Pound)
