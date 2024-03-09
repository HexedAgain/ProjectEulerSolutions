package solutions.project37

import extensions.*
import solutions.NoArgSolution
import utils.primes.PrimeSieve

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

    val leftTruncatablePrimes: MutableList<Int> = mutableListOf()

    override fun solve(): Int {
        return getBothWayTruncatablePrimes().sum()
    }

    fun getBothWayTruncatablePrimes(): List<Int> {
        if (primesUpto < 23) return listOf()
        val primesList = PrimeSieve(maxPrime = primesUpto).sieve()
        primes = primesList.toSet()
//        primesList.filter { it in 23..99 }.forEach {
//            if (isLeftTruncatable(it)) {
//                leftTruncatablePrimes.add(it)
//            }
//        }
        val x = 123.firstNDigits(digits = 2)
        return primesList.filter(::truncatablePredicate)
    }

    fun getBothWayTruncatablePrimes2(): List<Int> {
        if (primesUpto < 23) return listOf()
        val primesList = PrimeSieve(maxPrime = primesUpto).sieve()
        primes = primesList.toSet()
        return primesList.filter(::truncatablePredicate)
    }

    private fun truncatablePredicate(prime: Int): Boolean {
        val lastDigit = prime % 10
        val firstDigit = prime.firstDigit()
        return prime >= 23 &&
               (firstDigit == 2 || firstDigit == 3 || firstDigit == 5 || firstDigit == 7) &&
               (lastDigit == 2 || lastDigit == 3 || lastDigit == 5 || lastDigit == 7) &&
               isLeftTruncatable(prime) &&
               isRightTruncatable(prime)

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
        var modulo = prime.clampToPowTen()
        while (modulo > 0) {
            if (!primes.contains(truncatedPrime)) return false
            truncatedPrime %= modulo
            modulo /= 10
        }
        return true
    }
}