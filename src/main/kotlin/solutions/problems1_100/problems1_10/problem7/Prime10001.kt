package solutions.problems1_100.problems1_10.problem7

import solutions.NoArgSolution
import utils.primes.PrimeSieve

class Prime10001: NoArgSolution<Int> {
    override val problemNumber = 7
    override val problemName = "10001st Prime"

    override fun solve(): Int {
        return PrimeSieve(maxPrime = 1000_000).sieveSequence()
            .take(10_001)
            .last().toInt()
    }
}