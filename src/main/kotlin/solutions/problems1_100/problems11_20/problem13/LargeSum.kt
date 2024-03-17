package solutions.problems1_100.problems11_20.problem13

import extensions.firstNDigits
import extensions.iPow
import solutions.NoArgSolution

/*
  Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
 */
class LargeSum: NoArgSolution<Long> {
    override val problemNumber = 13
    override val problemName = "Large Sum"
    override val problemNotes = """
        We first need to figure out how many digits after 10 will play any part in the final result. Consider the 14th
        digit, if all of these were 9, this would introduce a carry of 90 onto the 13th line. If the 13th digits were
        also all 9s this would introduce a carry of 99 onto the 12th line, and if the 12th digits were also 9, this would
        introduce a carry of 99 onto the 11th line. So really the 14th digit doesn't really contribute anything to the
        final sum. We can take the first 13 digits of every line and add them.
    """.trimIndent()

    override fun solve(): Long {
        return firstNLines(nLines = 100, nDigits = 10)
    }

    fun firstNLines(nLines: Int, nDigits: Int): Long {
        if (nDigits > 10) throw IllegalStateException("nDigits must not exceed 10")
        if (nLines > 100) throw IllegalStateException("nLines must not exceed 100")
        val numbers = loadResourceFile("problem13.txt").take(nLines).map { it.substring(0, 13).toLong() }
        return numbers.sum().firstNDigits(digits = nDigits)
    }
}