package utils.numbers

import extensions.divides
import extensions.lPow
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
    val factors = mutableMapOf(1L to 1L)
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

// could probably do this faster if done *whilst* getting factors
fun divisors(n: Long): List<Long> {
    fun recursiveDivisors(primePowers: List<List<Long>>): List<Long> {
        if (primePowers.size == 1) return primePowers.first()

        val (first, second) = primePowers.take(2)
        val products = first + first.map { f -> second.map { s -> f * s } }.flatten()
        return recursiveDivisors(listOf(products) + primePowers.drop(2))
    }

    val factors = factorise(n)
    val distinctPrimePowers = factors
        .map { entry ->
            val lhs = if (entry == factors.entries.first()) 0 else 1
            (lhs..entry.value).map { entry.key.lPow(it) }
        }
    return recursiveDivisors(distinctPrimePowers)
}

fun fib(term: Int): Int {
    fun fibTailRecursive(f1: Int, f2: Int, term: Int): Int {
        return when (term) {
            0 -> 0
            1 -> 1
            2 -> f1 + f2
            else -> fibTailRecursive(f2, f1 + f2, term - 1)
        }
    }

    return fibTailRecursive(0, 1, term)
}

/**
 * Finds the sum of n terms with common difference d, starting at a.
 * Passing only n returns sum of the first n numbers
 */
fun sum(n: Int, a: Int = 1, d: Int = 1): Int {
    return n * ((2 * a) + ((n - 1) * d)) / 2
}