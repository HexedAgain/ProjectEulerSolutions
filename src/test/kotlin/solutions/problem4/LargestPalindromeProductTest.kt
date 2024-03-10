package solutions.problem4

import org.junit.Assert.assertEquals
import org.junit.Test

class LargestPalindromeProductTest {
    @Test
    fun `isPalindrome returns true if number is a palindrome and false otherwise`() {
        assertEquals(true, LargestPalindromeProduct().isPalindrome(16461))
        assertEquals(true, LargestPalindromeProduct().isPalindrome(1))
        assertEquals(true, LargestPalindromeProduct().isPalindrome(55))
        assertEquals(true, LargestPalindromeProduct().isPalindrome(232))
        assertEquals(true, LargestPalindromeProduct().isPalindrome(4774))

        assertEquals(false, LargestPalindromeProduct().isPalindrome(54))
        assertEquals(false, LargestPalindromeProduct().isPalindrome(233))
        assertEquals(false, LargestPalindromeProduct().isPalindrome(4764))
        assertEquals(false, LargestPalindromeProduct().isPalindrome(17481))
    }

    @Test
    fun `largestPalindromeProduct, for maxDigits equal to 1 it returns 81`() {
        assertEquals(9, LargestPalindromeProduct().largestPalindromeProduct(maxDigits = 1))
    }
    @Test
    fun `largestPalindromeProduct, for maxDigits equal to 2 it returns 9009`() {
        assertEquals(9009, LargestPalindromeProduct().largestPalindromeProduct(maxDigits = 2))
    }
    @Test
    fun `solve, returns expected answer of 906609`() {
        assertEquals(906609, LargestPalindromeProduct().solve())
    }
}