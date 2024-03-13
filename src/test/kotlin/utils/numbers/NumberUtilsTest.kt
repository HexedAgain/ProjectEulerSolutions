package utils.numbers

import org.junit.Assert
import org.junit.Test
import kotlin.test.assertEquals

class NumberUtilsTest {
    @Test
    fun `factorise, it factorises primes correctly`() {
        Assert.assertEquals(mutableMapOf(1L to 1L, 2L to 1L), factorise(2))
        Assert.assertEquals(mutableMapOf(1L to 1L, 13L to 1L), factorise(13))
    }

    @Test
    fun `factorise, it factorises simple non-squarefree primes correctly`() {
        Assert.assertEquals(mutableMapOf(1L to 1L, 2L to 3L), factorise(8))
        Assert.assertEquals(mutableMapOf(1L to 1L, 13L to 2L), factorise(169))
    }

    @Test
    fun `factorise, it factorises mixed squarefree primes correctly`() {
        Assert.assertEquals(mutableMapOf(1L to 1L, 2L to 1L, 3L to 1L), factorise(6))
        Assert.assertEquals(mutableMapOf(1L to 1L, 13L to 1L, 17L to 1L), factorise(221))
    }

    @Test
    fun `factorise, it factorises mixed non-squarefree primes correctly`() {
        Assert.assertEquals(mutableMapOf(1L to 1L, 2L to 3L, 3L to 3L), factorise(216))
        Assert.assertEquals(mutableMapOf(1L to 1L, 13L to 2L, 17L to 3L), factorise(830297))
    }

    @Test
    fun `factorise, it factorises product of two distant primes correctly`() {
        Assert.assertEquals(mutableMapOf(1L to 1L, 13L to 1L, 9973L to 1L), factorise(129649))
        Assert.assertEquals(mutableMapOf(1L to 1L, 13L to 3L, 9973L to 2L), factorise(218515221613))
    }

    @Test
    fun `sum, it calculates the sum of the first 10 numbers as 55`() {
        assertEquals(55, sum(n = 10))
    }

    @Test
    fun `sum, it calculates the sum of the first 10 even numbers starting at 4 as (110 - 2 + 22) = 130`() {
        assertEquals(130, sum(n = 10, d = 2, a = 4))
    }

    @Test
    fun `divisors, it finds the divisor of 1 to be (1)`() {
        // FIXME do I want factors to always include 1!?
        assertEquals(listOf(1L), divisors(1L))
    }

    @Test
    fun `fib, it calculates the first 10 fibonacci numbers correctly`() {
        assertEquals(0, fib(0))
        assertEquals(1, fib(1))
        assertEquals(1, fib(2))
        assertEquals(2, fib(3))
        assertEquals(3, fib(4))
        assertEquals(5, fib(5))
        assertEquals(8, fib(6))
        assertEquals(13, fib(7))
        assertEquals(21, fib(8))
        assertEquals(34, fib(9))
    }
}