package utils.primes

import kotlin.math.log10
import kotlin.math.pow

fun clampToPowTen(n: Int): Int {
    val log10 = log10(n.toDouble()).toInt()
    return 10.0.pow(log10.toDouble()).toInt()
}

fun clampToPowTen(n: Long): Long {
    val log10 = log10(n.toDouble()).toLong()
    return 10.0.pow(log10.toDouble()).toLong()
}
