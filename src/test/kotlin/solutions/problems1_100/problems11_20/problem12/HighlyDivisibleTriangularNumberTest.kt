package solutions.problems1_100.problems11_20.problem12

import org.junit.Assert.*
import org.junit.Test

class HighlyDivisibleTriangularNumberTest {
    @Test
    fun `smallestTriangular, given divisors = 5, it finds the smallest triangular number 28`() {
        HighlyDivisibleTriangularNumber().divisors(84 * 3 * 7)
        assertEquals(28, HighlyDivisibleTriangularNumber().smallestTriangular(numDivisors = 28))
    }
}