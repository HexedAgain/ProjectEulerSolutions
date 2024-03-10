package solutions.problems1_100.problems1_10.problem8

import solutions.NoArgSolution
import kotlin.math.max

/*
   The four adjacent digits in the 1000-digit number that have the greatest product are 9 * 9 * 8 * 9 = 5832.
   Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
 */
class LargestProductInSeries: NoArgSolution<Long> {
    override val problemNumber = 8
    override val problemName = "Larges Product In A Series"
    override val problemNotes = """
        For this one we need to linear scan the file and attempt consume 13 adjacent digits; if we are successful then
        update the largest found product, move a character to the right and consume the next 13 characters, and so on...
        As an optimisation, if we ever find a zero then we can jump ahead to start scanning immediately after it (as any
        such product will contain a zero)
    """.trimIndent()

    override fun solve(): Long {
        return findAdjacentProduct(numAdjacent = 13)
    }

    fun findAdjacentProduct(numAdjacent: Int): Long {
        val numbers = loadResourceFile(filename = "problem8.txt")
            .joinToString("")
            .map { Integer.parseInt(it.toString()).toLong() }
        var finishedScanning = false
        var left = 0
        var largestProduct = 0L
        while (!finishedScanning) {
            val digits = numbers.subList(left, left + numAdjacent)
            val product = digits.reduce { acc, i -> acc * i }
            left += if (product == 0L) numAdjacent else 1
            largestProduct = max(product, largestProduct)

            if (left + numAdjacent >= numbers.size) finishedScanning = true
        }

        return largestProduct
    }
}