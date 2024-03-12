package solutions.problems1_100.problems11_20.problem12

import extensions.lPow
import solutions.NoArgSolution
import utils.numbers.factorise

class HighlyDivisibleTriangularNumber: NoArgSolution<Long> {
    override val problemNumber = 12
    override val problemName = "Highly Divisible Triangular Number"
    override val problemNotes = """
        
    """.trimIndent()

    override fun solve(): Long {
        return 0L
    }

    internal fun smallestTriangular(numDivisors: Int): Long {
        return 0L
    }

    fun divisors(n: Long): List<Long> {
//        val factors = factorise(n)
        val distinctPrimePowers = factorise(n)
            .map { entry -> (1..entry.value).map { entry.key.lPow(it) } }
            .flatten()
        return _divisors2(distinctPrimePowers)
//        return _divisors(factors, setOf(1))
    }

    fun _divisors(factors: Map<Long, Long>, products: Set<Long>): Set<Long> {
        if (factors.isEmpty()) return products
        val entry = factors.entries.first()
        val remainingFactors = factors.filter { it != entry }
        val theseProducts = (1..entry.value).map { entry.key.lPow(it) }.toSet()
        return _divisors(remainingFactors, theseProducts)
    }

    fun _divisors2(primePowers: List<Long>): List<Long> {
        val lhs = primePowers
        val remainingPrimePowers = primePowers.drop(1)
        return listOf()
    }

    fun <T> permutations(items: List<T>): List<T> {
        return listOf()
    }
}