package solutions.project1

import solutions.NoArgSolution

/*
   If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
   Find the sum of all the multiples of 3 or 5 below 1000.
 */
class MultiplesOf3Or5: NoArgSolution<Int> {
    override val problemNumber = 1
    override val problemName = "Multiples of 3 or 5"

    override fun solve(): Int {
        return multiplesUpToN(1000)
    }


    fun multiplesUpToN(max: Int): Int {
        if (max < 2) return 0
        return sum(3, max) + sum(5, max) - sum(15, max)
    }

    private fun sum(n: Int, max: Int): Int {
        var sum = 0
        (n..max step n).forEach {
            sum += it
        }
        return sum
    }
}