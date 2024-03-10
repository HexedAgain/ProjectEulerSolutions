package solutions.problems1_100.problems1_10.problem7

import solutions.NoArgSolution
import utils.primes.PrimeSieve

class Prime10001: NoArgSolution<Int> {
    override val problemNumber = 7
    override val problemName = "10001st Prime"
    override val problemNotes = """
        Through the course of solving other problems I had already built a prime sieve and so I just needed to inspect
        the 10001st prime. Upfront I'm not sure exactly how many primes need sieving so I over-sieve and then collect
        the primes in a sequence.
        If I didn't have a sieve I'd probably have to loop through the odd numbers and check each one for whether it is
        prime.
    """.trimIndent()

    override fun solve(): Int {
        return PrimeSieve(maxPrime = 1000_000).sieveSequence()
            .take(10_001)
            .last().toInt()
    }
}