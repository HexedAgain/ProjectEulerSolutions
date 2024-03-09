package solutions.project37

import extensions.*
import solutions.NoArgSolution
import utils.primes.PrimeChecker
import utils.primes.PrimeSieve
import kotlin.math.log10
import kotlin.math.pow

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
    private val primeChecker = PrimeChecker()
    override val problemNumber = 37
    override val problemName = "Truncatable Primes"

    var candidatePrimes: MutableList<Int> = mutableListOf()

    override fun solve(): Int {
        return getBothWayTruncatablePrimes3().sum()
    }

    fun getBothWayTruncatablePrimes3(): List<Int> {
        if (primesUpto < 23) return listOf()
        candidatePrimes = (23..99).filter { primeChecker.checkPrime(it) && isLeftTruncatable2(it) }.toMutableList()
        (3..log10(primesUpto.toDouble()).toInt()).forEach {
            val minPrime = 10.0.pow(it - 2)
            val oldList = candidatePrimes.filter { p -> p > minPrime }
            oldList.forEach { p ->
                listOf(1,3,7,5,9).forEach { digit ->
                    val newP = p * 10 + digit
                    if (primeChecker.checkPrime(newP) && isLeftTruncatable2(newP)) {
                        candidatePrimes.add(newP)
                    }
                }
            }
        }
        return candidatePrimes.filter { isRightTruncatable2(it) && it <= primesUpto }
    }

    fun getBothWayTruncatablePrimes(): List<Int> {
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

    private fun isLeftTruncatable2(prime: Int): Boolean {
        var truncatedPrime = prime
        while (truncatedPrime > 0) {
            if (!primeChecker.checkPrime(truncatedPrime)) return false
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

    private fun isRightTruncatable2(prime: Int): Boolean {
        var truncatedPrime = prime
        var modulo = prime.clampToPowTen()
        while (modulo > 0) {
            if (!primeChecker.checkPrime(truncatedPrime)) return false
            truncatedPrime %= modulo
            modulo /= 10
        }
        return true
    }
}