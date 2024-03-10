package solutions.problems1_100.problems1_10.problem3

import extensions.divides
import extensions.iSqrt
import extensions.lSqrt
import solutions.NoArgSolution
import utils.primes.PrimeSieve

/*
    The prime factors of 13195 are 5, 7, 13 and 29.
    What is the largest prime factor of the number 600851475143?
 */
class LargestPrimeFactor: NoArgSolution<Long> {
    override val problemNumber = 3
    override val problemName = "Largest Prime Factor"

    override fun solve(): Long {
        return largestPrimeFactor(600851475143)
    }

    internal fun largestPrimeFactor(n: Long): Long {
        return when (n) {
            0L -> 0L
            1L -> 1L
            else -> findLargestPrimeFactor(n)
        }
    }

    private fun findLargestPrimeFactor(n: Long): Long {
        val sqrtPrimes = PrimeSieve(maxPrime = lSqrt(n)).sieve()
        var latestN = n
        var lastP = 0L
        sqrtPrimes.forEach { p ->
            while (p divides latestN) {
                latestN /= p
                lastP = p
            }
            if (lastP >= latestN) return lastP
        }
        return latestN
    }
}