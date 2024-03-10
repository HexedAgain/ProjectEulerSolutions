package utils.primes

import extensions.isPositive
import kotlin.math.sqrt

class PrimeSieve(
    private val maxPrime: Long
) {
    private val _maxPrime = (maxPrime - 1) / 2
    private val _sqrtMaxPrime = sqrt(maxPrime.toDouble())
    private val sievePrimes: MutableList<Long>
    init {
        val capacity = ((maxPrime.takeIf { it > 2 } ?: 0) + 1) / 2
        sievePrimes = MutableList(capacity.toInt()) { 0L }
    }

    fun sieve(): List<Long> {
        if (maxPrime <= 1L) return listOf()
        if (maxPrime == 2L) return listOf(2)

        (3.._sqrtMaxPrime.toLong() step 2).forEach { sieveFor(it) }

        return collectPrimes()
    }

    /**
     * Not really so efficient as the actual sieve is done first, only the primes are collected as a sequence
     */
    fun sieveSequence(): Sequence<Long> {
        if (maxPrime <= 1L) return sequenceOf()
        if (maxPrime == 2L) return sequenceOf(2)

        (3.._sqrtMaxPrime.toLong() step 2).forEach { sieveFor(it) }

        return collectPrimesSequence()
    }

    private fun sieveFor(prime: Long) {
        // 3: strike out 9, 15, 21, ...
        // 5: strike out 25, 35, ...
        val start = ((prime * prime) / 2)
        (start.._maxPrime step prime).forEach {
            sievePrimes[it.toInt()] = 1
        }
    }

    private fun collectPrimes(): List<Long> {
        return listOf(2L) + sievePrimes.subList(1, sievePrimes.size)
            .mapIndexed { idx, i -> if (i == 0L) 1 + ((idx + 1) * 2L) else -1 }
            .filter { it.isPositive() }
    }
    private fun collectPrimesSequence(): Sequence<Long> {
        return (listOf(0) + sievePrimes.subList(1, sievePrimes.size))
            .asSequence()
            .mapIndexed { idx, i ->
                when {
                    idx == 0 -> 2
                    i == 0L -> 1 + (idx * 2L)
                    else -> -1
                }
            }
            .filter { it.isPositive() }
    }
}