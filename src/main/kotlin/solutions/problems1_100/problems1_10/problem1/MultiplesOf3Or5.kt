package solutions.problems1_100.problems1_10.problem1

import solutions.NoArgSolution
import kotlin.math.floor

/*
   If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
   Find the sum of all the multiples of 3 or 5 below 1000.
 */
class MultiplesOf3Or5: NoArgSolution<Int> {
    override val problemNumber = 1
    override val problemName = "Multiples of 3 or 5"
    override val problemNotes = """
        The trick to this one is to observe that though we are only looking for the sum of multiples of 3 or 5, there is
        the problem of double counting due to multiples of 15 being both multiples of 3 AND 5. As such we want to 
        calculate Sum_3 + Sum_5 - Sum_15 where Sum_i denotes the sum of multiples of i
    """.trimIndent()

    override fun solve(): Int {
        return multiplesUpToN(999)
    }


    internal fun multiplesUpToN(max: Int): Int {
        if (max < 2) return 0
        return sum(3, max) + sum(5, max) - sum(15, max)
    }

    private fun sumLinear(n: Int, max: Int): Int {
        var sum = 0
        (n..max step n).forEach {
            sum += it
        }
        return sum
    }

    private fun sum(d: Int, max: Int): Int {
        val numTerms = floor(max.toDouble() / d).toInt()
        return utils.numbers.sum(n = numTerms, a = d, d = d)
    }
}