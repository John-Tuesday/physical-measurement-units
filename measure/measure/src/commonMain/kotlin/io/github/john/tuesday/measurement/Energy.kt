package io.github.john.tuesday.measurement

import kotlin.math.absoluteValue

/**
 * Measure of Energy
 */
public class Energy internal constructor(
    internal val joules: Double
) : Comparable<Energy> {
    override fun compareTo(other: Energy): Int = joules.compareTo(other.joules)

    override fun toString(): String = "Energy(joules = $joules)"

    /**
     * Compares equality based on the underlying length value
     */
    override fun equals(other: Any?): Boolean = other is Energy && (compareTo(other) == 0)
    override fun hashCode(): Int = joules.hashCode()

    public companion object
}

/**
 * Unit of measurement for [Energy]
 */
public enum class EnergyUnit(internal val toJouleScale: Double) {
    Joule(1.0),
    Kilojoule(1_000.0),
    Megajoule(1_000_000.0),
    Calorie(4.184),
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

public val Number.joules: Energy get() = Energy(toDouble(), EnergyUnit.Joule)
public fun Energy.inJoules(): Double = inUnitsOf(EnergyUnit.Joule)
public val Number.kilojoules: Energy get() = Energy(toDouble(), EnergyUnit.Kilojoule)
public fun Energy.inKilojoules(): Double = inUnitsOf(EnergyUnit.Kilojoule)
public val Number.megajoules: Energy get() = Energy(toDouble(), EnergyUnit.Megajoule)
public fun Energy.inMegajoules(): Double = inUnitsOf(EnergyUnit.Megajoule)
public val Number.calories: Energy get() = Energy(toDouble(), EnergyUnit.Calorie)
public val Number.cal: Energy get() = this.calories
public fun Energy.inCalories(): Double = inUnitsOf(EnergyUnit.Calorie)
public val Number.kilocalories: Energy get() = Energy(toDouble(), EnergyUnit.Kilocalorie)
public val Number.kcal: Energy get() = this.kilocalories
public fun Energy.inKilocalories(): Double = inUnitsOf(EnergyUnit.Kilocalorie)
