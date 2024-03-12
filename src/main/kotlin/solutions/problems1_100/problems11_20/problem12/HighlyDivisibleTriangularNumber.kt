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
        fun recursiveDivisors(primePowers: List<List<Long>>): List<Long> {
            if (primePowers.size == 1) return primePowers.first()
            val (first, second) = primePowers.take(2)
            val rest = primePowers.drop(2)
            val products = first + first.map { f -> second.map { s -> f * s } }.flatten()
            return recursiveDivisors(listOf(products) + rest)
        }

        val factors = factorise(n)
        val distinctPrimePowers = factors
            .toMutableMap()
            .map { entry ->
                val lhs = if (entry == factors.entries.first()) 0 else 1
                (lhs..entry.value).map { entry.key.lPow(it) }
            }
        return recursiveDivisors(distinctPrimePowers)
    }


    // [{1}, {2, 4}, {3, 9}] -> [{1, 2, 4}, {3, 9}] -> [{1, 3, 9, 2, 6, 18, 4, 12, 36}]
    // [{2, 4}, {3, 9}, {1}] -> [{2, 6, 18, 4, 12, 36}, {1}] :/

    fun <T> permutations(items: List<T>): List<T> {
        return listOf()
    }
}