package solutions.problems1_100.problems1_10.problem5

import extensions.lPow
import solutions.NoArgSolution
import utils.numbers.factorise
import utils.numbers.lSqrt
import utils.primes.PrimeSieve

/*
    2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
    What is the smallest positive number that is evenly divisible (i.e. no reminder) by all of the numbers from 1 to 20?
 */
class SmallestMultiple: NoArgSolution<Long> {
    override val problemNumber = 5
    override val problemName = "Smallest Multiple"
    override val problemNotes = """
        The naive approach to this one is just to multiply all numbers from 1 to 20, but this is going to be double
        counting divisors. Really for the solution number we want to know its prime factors. If we knew that then
        we can just multiply those (well powers of those). The solution I took here, not necessarily optimal, is to
        first factorise each of the integers in 1..20, from this form a map of divisors and their powers, and then from
        this find the product of prime powers.
    """.trimIndent()

    override fun solve(): Long {
        return smallestMultiple(numbersUpTo = 20L)
    }
    lateinit var primes: List<Long>

    internal fun smallestMultiple(numbersUpTo: Long): Long {
        if (!::primes.isInitialized) {
            primes = PrimeSieve(maxPrime = lSqrt(numbersUpTo)).sieve()
        }
        return getDivisorPowers(numbersUpTo = numbersUpTo)
            .map { it.key.lPow(it.value) }
            .reduce { acc, v -> v * acc }
    }

    private fun getDivisorPowers(numbersUpTo: Long): Map<Long, Long> {
        val divisors = mutableMapOf<Long, Long>()
        (2 ..numbersUpTo).forEach { n ->
            factorise(n, primes).forEach { factor ->
                divisors[factor.key]?.let {
                    if (it < factor.value) {
                        divisors[factor.key] = factor.value
                    }
                } ?: run {
                    divisors.put(factor.key, factor.value)
                }
            }
        }
        return divisors
    }
}