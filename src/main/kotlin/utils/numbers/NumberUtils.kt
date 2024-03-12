package utils.numbers

import extensions.divides
import utils.primes.PrimeSieve
import kotlin.math.sqrt

fun iSqrt(n: Int): Int {
    return sqrt(n.toDouble()).toInt()
}

fun lSqrt(n: Long): Long {
    return sqrt(n.toDouble()).toLong()
}

fun factorise(n: Long): Map<Long, Long> {
    return factorise(n, PrimeSieve(maxPrime = lSqrt(n)).sieve())
}

fun factorise(n: Long, primes: List<Long>): Map<Long, Long> {
    val factors = mutableMapOf<Long, Long>()
    var latestN = n
    primes.forEach {
        while (it divides latestN) {
            latestN /= it
            val rhs = factors.getOrPut(it) { 0L }
            factors[it] = rhs + 1
        }
    }
    if (factors.isEmpty()) {
        return mapOf(n to 1)
    } else {
        if (latestN != 1L) {
            factors.getOrPut(latestN) { 1L }
        }
        return factors
    }
}

fun fib(numTerms: Int): Int {
    return fibTailRecursive(0, 1, numTerms)
}
private fun fibTailRecursive(f1: Int, f2: Int, numTerms: Int): Int {
    return when (numTerms) {
        1 -> 0
        2 -> f1 + f2
        else -> fibTailRecursive(f2, f1 + f2, numTerms - 1)
    }
}

/**
 * Finds the sum of n terms with common difference d, starting at a
 */
fun sum(n: Int, a: Int = 1, d: Int = 1): Int {
    return n * ((2 * a) + ((n - 1) * d)) / 2
}