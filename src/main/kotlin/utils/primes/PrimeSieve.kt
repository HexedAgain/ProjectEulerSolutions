package utils.primes

import extensions.isPositive

class PrimeSieve(
    private val maxPrime: Int
) {
    private val _maxPrime = (maxPrime - 1) / 2
    private val _sqrtMaxPrime = Math.sqrt(maxPrime.toDouble())
    private val sievePrimes: MutableList<Int>
    init {
        val capacity = ((maxPrime.takeIf { it > 2 } ?: 0) + 1) / 2
        sievePrimes = MutableList(capacity) { 0 }
    }

    fun sieve(): List<Int> {
        if (maxPrime <= 1) return listOf()
        if (maxPrime == 2) return listOf(2)

        (3.._sqrtMaxPrime.toInt() step 2).forEach { sieveFor(it) }

        return collectPrimes()
    }

    private fun sieveFor(prime: Int) {
        // 3: strike out 9, 15, 21, ...
        // 5: strike out 25, 35, ...
        val start = ((prime * prime) / 2)
        (start.._maxPrime step prime).forEach {
            sievePrimes[it] = 1
        }
    }

    private fun collectPrimes(): List<Int> {
        return listOf(2) + sievePrimes.subList(1, sievePrimes.size)
            .mapIndexed { idx, i -> if (i == 0) 1 + ((idx + 1) * 2) else -1 }
            .filter { it.isPositive() }
    }
}