package solutions.problems1_100.problems1_10.problem2

import org.junit.Assert.*
import solutions.problems1_100.problems1_10.problem2.EvenFibonacciNumbers
import kotlin.test.Test

class EvenFibonacciNumbersTest {
    @Test
    fun `fibLinear, if upper bound is less than 2 it returns 0`() {
        assertEquals(0, EvenFibonacciNumbers().fibLinear(0))
        assertEquals(0, EvenFibonacciNumbers().fibLinear(1))
    }
    @Test
    fun `fibLinear, if upper bound is 2 it returns 2`() {
        assertEquals(2, EvenFibonacciNumbers().fibLinear(2))
    }
    @Test
    fun `fibLinear, if upper bound is 10 it returns 2 + 8 = 10`() {
        assertEquals(10, EvenFibonacciNumbers().fibLinear(10))
    }
    @Test
    fun `solve, it returns expected answer of 4613732`() {
        assertEquals(4613732, EvenFibonacciNumbers().solve())
    }
    @Test
    fun `fibRecursive, it returns the correct fibonacci number for the given numTerms`() {
        assertEquals(0, EvenFibonacciNumbers().fibRecursive(1))
        assertEquals(1, EvenFibonacciNumbers().fibRecursive(2))
        assertEquals(2, EvenFibonacciNumbers().fibRecursive(3))
        assertEquals(3, EvenFibonacciNumbers().fibRecursive(4))
        assertEquals(5, EvenFibonacciNumbers().fibRecursive(5))
        assertEquals(8, EvenFibonacciNumbers().fibRecursive(6))
        assertEquals(13, EvenFibonacciNumbers().fibRecursive(7))
        assertEquals(21, EvenFibonacciNumbers().fibRecursive(8))
        assertEquals(34, EvenFibonacciNumbers().fibRecursive(9))
        assertEquals(55, EvenFibonacciNumbers().fibRecursive(10))
    }
}