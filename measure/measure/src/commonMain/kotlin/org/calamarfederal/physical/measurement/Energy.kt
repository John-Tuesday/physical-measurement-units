package org.calamarfederal.physical.measurement

import kotlin.math.absoluteValue

/**
 * Measure of Energy
 */
class Energy internal constructor(
    internal val joules: Double
) : Comparable<Energy> {
    override fun compareTo(other: Energy): Int = joules.compareTo(other.joules)

    override fun toString(): String = "Energy(joules = $joules)"

    /**
     * Compares equality based on the underlying length value
     */
    override fun equals(other: Any?): Boolean = other is Energy && (compareTo(other) == 0)
    override fun hashCode(): Int = joules.hashCode()

    companion object
}

enum class EnergyUnit(internal val toJouleScale: Double) {
    Joule(1.0),
    Kilojoule(1_000.0),
    Megajoule(1_000_000.0),
    Calorie(4.184),
    Kilocalorie(4184.0),
    ;
}

fun Energy.inUnitsOf(energyUnit: EnergyUnit): Double = joules / energyUnit.toJouleScale

/**
 * Alternate constructor pattern for [Energy]
 *
 * creates a [Energy] with [amount] number of [energyUnit]
 */
operator fun Energy.Companion.invoke(amount: Number, energyUnit: EnergyUnit): Energy =
    Energy(joules = amount.toDouble() * energyUnit.toJouleScale)

/**
 * Negate the underlying value
 */
operator fun Energy.unaryMinus(): Energy = Energy(joules = -joules)

val Energy.absoluteValue: Energy get() = Energy(joules = joules.absoluteValue)

operator fun Energy.plus(other: Energy): Energy = Energy(joules = joules + other.joules)
operator fun Energy.minus(other: Energy): Energy = Energy(joules = joules - other.joules)

/**
 * Ratio of `this` to [other]
 */
operator fun Energy.div(other: Energy): Double = joules / other.joules

/**
 * Scale `this` by [number]
 */
operator fun Energy.times(number: Number): Energy = Energy(joules = joules * number.toDouble())
/**
 * Shrink `this` by [number]
 */
operator fun Energy.div(number: Number): Energy = Energy(joules = joules / number.toDouble())

val Number.joules: Energy get() = Energy(toDouble(), EnergyUnit.Joule)
fun Energy.inJoules(): Double = inUnitsOf(EnergyUnit.Joule)
val Number.kilojoules: Energy get() = Energy(toDouble(), EnergyUnit.Kilojoule)
fun Energy.inKilojoules(): Double = inUnitsOf(EnergyUnit.Kilojoule)
val Number.megajoules: Energy get() = Energy(toDouble(), EnergyUnit.Megajoule)
fun Energy.inMegajoules(): Double = inUnitsOf(EnergyUnit.Megajoule)
val Number.calories: Energy get() = Energy(toDouble(), EnergyUnit.Calorie)
val Number.cal: Energy get() = this.calories
fun Energy.inCalories(): Double = inUnitsOf(EnergyUnit.Calorie)
val Number.kilocalories: Energy get() = Energy(toDouble(), EnergyUnit.Kilocalorie)
val Number.kcal: Energy get() = this.kilocalories
fun Energy.inKilocalories(): Double = inUnitsOf(EnergyUnit.Kilocalorie)
