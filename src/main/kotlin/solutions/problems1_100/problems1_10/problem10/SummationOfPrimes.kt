package solutions.problems1_100.problems1_10.problem10

import solutions.NoArgSolution
import utils.primes.PrimeSieve

/*
    The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
    Find the sum of all the primes below two million.
 */
class SummationOfPrimes: NoArgSolution<Long> {
    override val problemNumber = 10
    override val problemName = "Summation Of Primes"
    override val problemNotes = """
        This one just needs a prime sieve.
    """.trimIndent()

    override fun solve(): Long {
        return PrimeSieve(maxPrime = 2000_000).sieve().sum()
    }
}