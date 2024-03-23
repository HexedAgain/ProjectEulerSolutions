package solutions.problems1_100.problems21_30.problem21

import solutions.NoArgSolution
import utils.numbers.divisors
import utils.primes.PrimeSieve

/*
    Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
    If d(a) = b and d(b) = a, where a =/= b, then a and b are an amicable pair and each of a and b are called amicable numbers.
    For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
    Evaluate the sum of all the amicable numbers under 10000.
 */
class AmicableNumbers: NoArgSolution<Int> {
    override val problemNumber = 21
    override val problemName = "Amicable Numbers"
    override val problemNotes = """
        Easiest solution is just to loop. But this is quite slow. We can save some work (but not much) by memoising
        divisor sums, and passing in a fixed primes array
    """.trimIndent()
    private val knownDivisorSums: MutableMap<Int, Int> = mutableMapOf()

    private val primes = PrimeSieve(maxPrime = 101).sieve()
    override fun solve(): Int {
        return allAmicable(upto = 10000).sum()
    }

    fun isAmicable(n: Int): Boolean {
        val dA = d(n)
        knownDivisorSums[n] = dA
        return dA != n && (knownDivisorSums[dA] ?: d(dA)) == n
    }

    fun allAmicable(upto: Int): List<Int> {
        return (1..upto).filter { isAmicable(it) }
    }

    fun d(n: Int): Int {
        return divisors(n, primes = primes, properDivisors = true).sum().toInt()
    }
}