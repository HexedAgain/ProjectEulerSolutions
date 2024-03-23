package solutions.problems1_100.problems11_20.problem20

import solutions.NoArgSolution
import utils.numbers.bigFactorial
import utils.numbers.factorial
import java.math.BigInteger

/*
    n! means n x (n - 1) x ... x 3 x 2 x 1. For example,
        10! = 10 x 9 x ... x 3 x 2 x 1 = 3628800,
    and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
    Find the sum of the digits in the number 100!.
 */
class FactorialDigitSum: NoArgSolution<Int> {
    override val problemNumber = 20
    override val problemName = "Factorial Digit Sum"
    override val problemNotes = """
        Will be easiest to get a BigInteger, do the product, split to a string and then sum the digits. Can save
        a little bit of work by exploiting that any multiple of 10 can be disregarded
    """.trimIndent()

    override fun solve(): Int {
        return 0
    }

    fun sumFactorialDigits(factorialDigit: Int): Int {
        return bigFactorial(factorialDigit.toLong())
            .toString(10)
            .sumOf { Integer.parseInt(it.toString()) }
    }
}