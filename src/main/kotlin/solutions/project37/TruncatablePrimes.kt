package solutions.project37

import solutions.NoArgSolution
import utils.primes.PrimeSieve
import kotlin.math.log10

/*
    The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right,
    and remain prime at each stage: 3797, 797, 97, and 7. Similarly, we can work from right to left: 3797, 379, 37, and 3.
    Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
    NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */

class TruncatablePrimes(
    private val primesUpto: Int = 1000_000,
): NoArgSolution<Int> {
    private lateinit var primes: Set<Int>
    override val problemNumber = 37
    override val problemName = "Truncatable Primes"

    private val leftTruncatablePrimes: MutableList<Int> = mutableListOf()
    private val rightTruncatablePrimes: MutableList<Int> = mutableListOf()

    override fun solve(): Int {
        return getBothWayTruncatablePrimes().sum()
    }

    fun getBothWayTruncatablePrimes(): List<Int> {
        if (primesUpto < 23) return listOf()
        val primesList = PrimeSieve(maxPrime = primesUpto).sieve()
        primes = primesList.toSet()
        primesList.filter { it >= 23 }.forEach {
            if (isLeftTruncatable(it)) {
                leftTruncatablePrimes.add(it)
            }
            if (isRightTruncatable(it)) {
                rightTruncatablePrimes.add(it)
            }
        }
        return leftTruncatablePrimes.filter { rightTruncatablePrimes.contains(it) }
    }

    private fun isLeftTruncatable(prime: Int): Boolean {
        var truncatedPrime = prime
        while (truncatedPrime > 0) {
            if (!primes.contains(truncatedPrime)) return false
            truncatedPrime /= 10
        }
        return true
    }

    private fun isRightTruncatable(prime: Int): Boolean {
        var truncatedPrime = prime
        var modulo = Math.pow(10.0, log10(prime.toDouble()).toInt().toDouble()).toInt()
        while (modulo > 0) {
            if (!primes.contains(truncatedPrime)) return false
            truncatedPrime %= modulo
            modulo /= 10
        }
        return true
    }
}