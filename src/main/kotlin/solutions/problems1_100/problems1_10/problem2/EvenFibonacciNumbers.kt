package solutions.problems1_100.problems1_10.problem2

import extensions.isEven
import solutions.NoArgSolution

/*
    Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
    1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
    By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 */
class EvenFibonacciNumbers: NoArgSolution<Int> {
    override val problemNumber = 2
    override val problemName = "Even Fibonacci numbers"
    override val problemNotes = """
        The easiest way to do this one is just to carry out the summation in a simple for loop. I couldn't resist the
        opportunity to introduce a tail recursive fibonacci sequence though (tail recursive is important as otherwise
        there's a good chance of blowing the stack)
    """.trimIndent()

    override fun solve(): Int {
        return sumFibRecursive(4_000_000)
    }

    internal fun fibLinear(upperBound: Int): Int {
        var f1 = 0
        var f2 = 1
        var f3 = 0
        var sum = 0
        while (f3 < upperBound) {
            f3 = f2 + f1
            f1 = f2
            f2 = f3
            if (f3.isEven()) { sum += f3 }
        }
        return sum
    }

    internal fun sumFibRecursive(upperBound: Int): Int {
        var sum = 0
        var numTerms = 0
        while (true) {
            numTerms += 1
            fibRecursive(numTerms).takeIf { it.isEven() }?.let {
                if (it >= upperBound) return sum
                sum += it
            }
        }
    }
    fun fibRecursive(numTerms: Int): Int {
        return _fibRecursive(0, 1, numTerms)
    }
    private fun _fibRecursive(f1: Int, f2: Int, numTerms: Int): Int {
        return when (numTerms) {
            1 -> 0
            2 -> f1 + f2
            else -> _fibRecursive(f2, f1 + f2, numTerms - 1)
        }
    }
}