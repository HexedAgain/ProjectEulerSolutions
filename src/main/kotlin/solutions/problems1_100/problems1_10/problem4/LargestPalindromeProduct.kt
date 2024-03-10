package solutions.problems1_100.problems1_10.problem4

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
    override val problemNotes = """
        A slow (ish) solution to this one is just to double loop through all the numbers in 1..999, form their product
        and if palindromic update the largest palindrome found (you can halve this work if the inner loop doesn't contain
        any numbers in the outer loop, i.e. a "triangular" loop).
        We could loop in reverse, but the trick is when to determine we found the largest palindrome, i.e. maybe we found
        such a palindrome with outerloop i = 999, and inner loop j = 1 but we know that there is a larger palindrome
        somewhere for a smaller i and larger j)
        A somewhat faster solution is to exploit that for any N, we can form a list of pairs:
        (999, 999 - N), (999 - 1, 999 - (N-1)), ... (999 - N, 999) and then form the products of first and second in each
        pair. In this way we can quickly home in on the largest palindrome. I.e. look for palindromes looping through:
        [(999, 999)], [(999, 998)], [(999, 997), (998, 998)], [(999, 996), (998, 997)], [(999, 995), (998, 996), (997, 997)],
        and so on ...
    """.trimIndent()

    override fun solve(): Int {
        return largestPalindromeProduct(maxDigits = 3)
    }

    override fun solveSlow(): Int {
        return largestPalindromeProductSlow(maxDigits = 3)
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
                val rhs = upperBound - (subtraction - partition)
                (lhs * rhs).takeIf { isPalindrome(it) }?.let { return it }
            }
        }
        return 0
    }

    internal fun isPalindrome(n: Int): Boolean {
        return with(n.toString()) { this == reversed() }
    }
}