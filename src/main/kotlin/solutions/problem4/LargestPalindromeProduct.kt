package solutions.problem4

import extensions.firstDigit
import extensions.firstNDigits
import extensions.lastDigit
import extensions.lastNDigits
import solutions.NoArgSolution
import kotlin.math.log10
import kotlin.math.pow

class LargestPalindromeProduct: NoArgSolution<Int> {
    override val problemName = "Largest Palindrome Product"
    override val problemNumber = 4

    override fun solve(): Int {
        return largestPalindromeProduct(maxDigits = 3)
    }

    internal fun largestPalindromeProductSlow(maxDigits: Int): Int {
        var largest = 0
        val upperBound = (10.0.pow(maxDigits) - 1).toInt()
        (1..upperBound).forEach { i ->
            (i..upperBound).forEach { j ->
                val product = i * j
                if (product > largest && isPalindrome(product) ) {
                    largest = product
                }
            }
        }
        return largest
    }

    internal fun largestPalindromeProduct(maxDigits: Int): Int {
        val upperBound = (10.0.pow(maxDigits) - 1).toInt()
        val totalPossibleSubtraction = upperBound * 2
        (0..totalPossibleSubtraction).forEach { subtraction ->
            (0..subtraction / 2).forEach { partition ->
                val lhs = upperBound - partition
                val rhs = upperBound - subtraction - partition
                (lhs * rhs).takeIf { isPalindrome(it) }?.let { return it }
            }
        }
        return 0
    }

    private fun getSubtractAmounts(totalAmount: Int): List<Pair<Int, Int>> {
        return (0..totalAmount / 2).map { Pair(it, totalAmount - it) }
    }

    internal fun isPalindrome(n: Int): Boolean {
        return with(n.toString()) { this == reversed() }
    }
}