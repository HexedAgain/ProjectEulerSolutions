package extensions

import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.sqrt

fun Int.isEven(): Boolean {
    return this % 2 == 0
}
fun Int.isOdd(): Boolean {
    return this % 2 == 1
}
fun Long.isEven(): Boolean {
    return this % 2 == 0L
}
fun Long.isOdd(): Boolean {
    return this % 2 == 1L
}

fun Int.isPositive(): Boolean {
    return this > 0
}
fun Long.isPositive(): Boolean {
    return this > 0L
}

/**
 * Returns max power of 10 LTE to input integer
 */
fun Int.clampToPowTen(): Int {
    val log10 = log10(this.toDouble()).toInt()
    return 10.0.pow(log10.toDouble()).toInt()
}

/**
 * Returns max power of 10 LTE to input long
 */
fun Long.clampToPowTen(): Long {
    val log10 = log10(this.toDouble()).toLong()
    return 10.0.pow(log10.toDouble()).toLong()
}

fun Int.firstDigit(): Int {
    return this / this.clampToPowTen()
}

fun Int.firstNDigits(digits: Int): Int {
    val powTenDigits = 10.0.pow(digits - 1)
    return if (this < powTenDigits) this else ((this * powTenDigits) / this.clampToPowTen()).toInt()
}

fun Int.lastDigit(): Int {
    return this % 10
}

fun Int.lastNDigits(digits: Int): Int {
    val powTenDigits = 10.0.pow(digits)
    return if (this < powTenDigits) this else (this % powTenDigits).toInt()
}

fun Long.firstDigit(): Int {
    return (this / this.clampToPowTen()).toInt()
}

fun Long.lastDigit(): Long {
    return this % 10
}

fun Long.firstNDigits(digits: Int): Long {
    val powTenDigits = 10.0.pow(digits - 1)
    return if (this < powTenDigits) this else ((this * powTenDigits) / this.clampToPowTen()).toLong()
}
fun Long.lastNDigits(digits: Int): Long {
    val powTenDigits = 10.0.pow(digits)
    return if (this < powTenDigits) this else (this % powTenDigits).toLong()
}

infix fun Int.divides(rhs: Int): Boolean {
    return ((rhs / this) * this == rhs)
}
infix fun Long.divides(rhs: Long): Boolean {
    return ((rhs / this) * this == rhs)
}
