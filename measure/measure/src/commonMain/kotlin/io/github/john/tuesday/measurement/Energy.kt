package io.github.john.tuesday.measurement

import kotlin.math.absoluteValue

/**
 * Measure of Energy
 */
public class Energy internal constructor(
    internal val joules: Double,
) : Comparable<Energy> {
    /**
     * Compare using natural order
     */
    override fun compareTo(other: Energy): Int = joules.compareTo(other.joules)

    /**
     * Returns string representation of the object
     */
    override fun toString(): String = "Energy(joules = $joules)"

    /**
     * Compares equality based on the underlying length value
     */
    override fun equals(other: Any?): Boolean = other is Energy && (compareTo(other) == 0)

    /**
     * Returns hash code of this object
     */
    override fun hashCode(): Int = joules.hashCode()

    /**
     * Public companion object for extensibility
     */
    public companion object
}

/**
 * Unit of measurement for [Energy]
 */
public enum class EnergyUnit(internal val toJouleScale: Double) {
    /**
     * Unit of measurement for [Energy]
     */
    Joule(1.0),

    /**
     * Unit of measurement for [Energy]
     */
    Kilojoule(1_000.0),

    /**
     * Unit of measurement for [Energy]
     */
    Megajoule(1_000_000.0),

    /**
     * Unit of measurement for [Energy]
     */
    Calorie(4.184),

    /**
     * Unit of measurement for [Energy]
     */
    Kilocalorie(4184.0),
    ;
}

/**
 * Calculate the value in terms of [energyUnit]
 */
public fun Energy.inUnitsOf(energyUnit: EnergyUnit): Double = joules / energyUnit.toJouleScale

/**
 * Creates an [Energy] with [amount] number of [energyUnit]
 */
public fun Energy(amount: Number, energyUnit: EnergyUnit): Energy =
    Energy(joules = amount.toDouble() * energyUnit.toJouleScale)

/**
 * Negate the underlying value
 */
public operator fun Energy.unaryMinus(): Energy = Energy(joules = -joules)

/**
 * Returns the absolute value of this value
 */
public val Energy.absoluteValue: Energy get() = Energy(joules = joules.absoluteValue)

/**
 * Return a new [Energy] whose value is the sum of the two [Energy]
 */
public operator fun Energy.plus(other: Energy): Energy = Energy(joules = joules + other.joules)

/**
 * Return a new [Energy] whose value is the difference between `this` and [other]
 *
 *     this - other
 */
public operator fun Energy.minus(other: Energy): Energy = Energy(joules = joules - other.joules)

/**
 * Ratio of `this` to [other]
 */
public operator fun Energy.div(other: Energy): Double = joules / other.joules

/**
 * Scale `this` by [number]
 */
public operator fun Energy.times(number: Number): Energy = Energy(joules = joules * number.toDouble())

/**
 * Shrink `this` by [number]
 */
public operator fun Energy.div(number: Number): Energy = Energy(joules = joules / number.toDouble())

/**
 * Returns an [Energy] equal to `this` number of joules
 */
public val Number.joules: Energy get() = Energy(toDouble(), EnergyUnit.Joule)

/**
 * Value of `this` [Energy] as a [Double] in units of joule
 */
public fun Energy.inJoules(): Double = inUnitsOf(EnergyUnit.Joule)

/**
 * Returns an [Energy] equal to `this` number of kilojoules
 */
public val Number.kilojoules: Energy get() = Energy(toDouble(), EnergyUnit.Kilojoule)

/**
 * Value of `this` [Energy] as a [Double] in units of kilojoule
 */
public fun Energy.inKilojoules(): Double = inUnitsOf(EnergyUnit.Kilojoule)

/**
 * Returns an [Energy] equal to `this` number of megajoules
 */
public val Number.megajoules: Energy get() = Energy(toDouble(), EnergyUnit.Megajoule)

/**
 * Value of `this` [Energy] as a [Double] in units of megajoule
 */
public fun Energy.inMegajoules(): Double = inUnitsOf(EnergyUnit.Megajoule)

/**
 * Returns an [Energy] equal to `this` number of calories
 */
public val Number.calories: Energy get() = Energy(toDouble(), EnergyUnit.Calorie)

/**
 * Returns an [Energy] equal to `this` number of calories
 */
public val Number.cal: Energy get() = this.calories

/**
 * Value of `this` [Energy] as a [Double] in units of calories
 */
public fun Energy.inCalories(): Double = inUnitsOf(EnergyUnit.Calorie)

/**
 * Returns an [Energy] equal to `this` number of kilocalories
 */
public val Number.kilocalories: Energy get() = Energy(toDouble(), EnergyUnit.Kilocalorie)

/**
 * Returns an [Energy] equal to `this` number of kilocalories
 */
public val Number.kcal: Energy get() = this.kilocalories

/**
 * Value of `this` [Energy] as a [Double] in units of kilocalories
 */
public fun Energy.inKilocalories(): Double = inUnitsOf(EnergyUnit.Kilocalorie)
