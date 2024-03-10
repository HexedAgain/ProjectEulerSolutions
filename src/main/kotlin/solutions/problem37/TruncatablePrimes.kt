package solutions.problem37

import extensions.*
import solutions.NoArgSolution
import utils.primes.PrimeChecker
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
    override val problemNumber = 37
    override val problemName = "Truncatable Primes"

    private val primeChecker = PrimeChecker()
    private var candidatePrimes: MutableList<Int> = mutableListOf()

    override fun solve(): Int {
        return getBothWayTruncatablePrimes().sum()
    }

    internal fun getBothWayTruncatablePrimes(): List<Int> {
        if (primesUpto < 23) return listOf()
        candidatePrimes = (23..99).filter { primeChecker.checkPrime(it) && isLeftTruncatable(it) }.toMutableList()
        (3..log10(primesUpto.toDouble()).toInt()).forEach {
            val minPrime = 10.0.pow(it - 2)
            val newCandidateList = candidatePrimes.filter { p -> p > minPrime }
            newCandidateList.forEach { p ->
                listOf(1,3,7,5,9).forEach { digit ->
                    val newP = p * 10 + digit
                    if (primeChecker.checkPrime(newP) && isLeftTruncatable(newP)) {
                        candidatePrimes.add(newP)
                    }
                }
            }
        }
        return candidatePrimes.filter { isRightTruncatable(it) && it <= primesUpto }
    }

    private fun isLeftTruncatable(prime: Int): Boolean {
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
            if (!primeChecker.checkPrime(truncatedPrime)) return false
            truncatedPrime %= modulo
            modulo /= 10
        }
        return true
    }
}