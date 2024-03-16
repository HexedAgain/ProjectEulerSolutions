package solutions.problems1_100.problems11_20.problem12

import org.junit.Assert.*
import org.junit.Test
import utils.numbers.divisors
import utils.numbers.factorise

class HighlyDivisibleTriangularNumberTest {
    @Test
    fun `smallestTriangular, given divisors = 5, it finds the smallest triangular number 28 with number of terms 7`() {
        val (numTerms, numDivisors, sum) = HighlyDivisibleTriangularNumber().smallestTriangular(numDivisorsRequired = 5)
        assertEquals(7, numTerms)
        assertEquals(6, numDivisors)
        assertEquals(28, sum)
    }
    @Test
    fun `smallestTriangular, given divisors = 10, it finds the smallest triangular number 78 with number of terms 12`() {
        val (numTerms, numDivisors, sum) = HighlyDivisibleTriangularNumber().smallestTriangular(numDivisorsRequired = 10)
        assertEquals(12, numTerms)
        assertEquals(12, numDivisors)
        assertEquals(78, sum)
    }
    @Test
    fun `solve, given divisors = 500, it finds the smallest triangular number 28 with number of terms 7`() {
        val (numTerms, numDivisors, sum) = HighlyDivisibleTriangularNumber().solve()
        assertEquals(12375, numTerms)
        assertEquals(576, numDivisors)
        assertEquals(76576500, sum)

        HighlyDivisibleTriangularNumber().smallestTriangular2(5)
    }
}