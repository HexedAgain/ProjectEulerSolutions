package solutions.problem3

import org.junit.Assert.assertEquals
import org.junit.Test

class LargestPrimeFactorTest {
    @Test
    fun `largestPrimeFactor, it reports the largest prime factor of zero as zero`() {
        assertEquals(0, LargestPrimeFactor().largestPrimeFactor(0))
    }
    @Test
    fun `largestPrimeFactor, it reports the largest prime factor of one as one`() {
        assertEquals(1, LargestPrimeFactor().largestPrimeFactor(1))
    }
    @Test
    fun `largestPrimeFactor, it reports the largest prime factor of a prime number as the prime itself`() {
        assertEquals(2, LargestPrimeFactor().largestPrimeFactor(2))
        assertEquals(3, LargestPrimeFactor().largestPrimeFactor(3))
        assertEquals(5, LargestPrimeFactor().largestPrimeFactor(5))
        assertEquals(7, LargestPrimeFactor().largestPrimeFactor(7))
        assertEquals(11, LargestPrimeFactor().largestPrimeFactor(11))
        assertEquals(10007, LargestPrimeFactor().largestPrimeFactor(10007))
    }
    @Test
    fun `largestPrimeFactor, it reports the largest prime factor of a composite number correctly`() {
        assertEquals(3, LargestPrimeFactor().largestPrimeFactor(6))
        assertEquals(2, LargestPrimeFactor().largestPrimeFactor(8))
        assertEquals(3, LargestPrimeFactor().largestPrimeFactor(24))
        assertEquals(23, LargestPrimeFactor().largestPrimeFactor(19 * 23))
    }
    @Test
    fun `solve, it finds the expected answer`() {
        assertEquals(6857, LargestPrimeFactor().solve())
    }
}