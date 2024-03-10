package solutions.problems1_100.problems1_10.problem6

import extensions.iPow
import solutions.NoArgSolution

class SumSquareDifference: NoArgSolution<Int> {
    override val problemNumber = 6
    override val problemName = "Sum Square Difference"

    override fun solve(): Int {
        return squareDifference(numbersUpto = 100)
    }

    internal fun squareDifference(numbersUpto: Int): Int {
        val numbersSquaredSum = (1..numbersUpto).sumOf { it.iPow(exponent = 2) }
        val numberSumSquared = (1..numbersUpto).sum().iPow(exponent = 2)
        return numberSumSquared - numbersSquaredSum
    }
}