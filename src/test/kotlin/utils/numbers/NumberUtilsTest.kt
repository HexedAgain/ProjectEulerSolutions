package utils.numbers

import org.junit.Assert
import org.junit.Test
import utils.primes.PrimeSieve
import java.math.BigInteger
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
        assertEquals(listOf(1L), divisors(1L))
    }
    @Test
    fun `divisors, it finds the divisors of 2 to be (1, 2)`() {
        assertEquals(listOf(1L, 2L), divisors(2L))
    }
    @Test
    fun `divisors, it finds the divisors of 2 x 2 x 3 x 3 to be (1, 2, 3, 4, 6, 9, 12, 18, 36)`() {
        assertEquals(listOf(1L, 2L, 3L, 4L, 6L, 9L, 12L, 18L, 36L), divisors(36L).sorted())
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

    @Test
    fun `numDivisors, it calculates the number of divisors of 1 as 1`() {
        assertEquals(1, numDivisors(1L))
    }

    @Test
    fun `numDivisors, it calculates the number of divisors of 2 as 2`() {
        assertEquals(2, numDivisors(2L))
    }

    @Test
    fun `numDivisors, it calculates the number of divisors of 2 x 2 as 3`() {
        assertEquals(3, numDivisors(4L))
    }
    @Test
    fun `numDivisors, it calculates the number of divisors of 2 x 2 x 2 x 3 x 5 as 16`() {
        assertEquals(16, numDivisors(120L))
    }
    @Test
    fun `numDivisors, it calculates the number of divisors of product of first 9 primes as 512`() {
        val primeProducts = PrimeSieve(maxPrime = 50).sieveSequence().take(9).reduce { acc, l -> l * acc }
        assertEquals(512, numDivisors(primeProducts))
        assertEquals(512, numDivisors(17297280))
    }

    @Test
    fun `realQuadraticRoots, it finds roots of (x+1)(x+1) to be (-1,-1)`() {
        assertEquals(Pair(-1.0, -1.0), realQuadraticRoots(1.0, 2.0, 1.0))
    }
    @Test
    fun `realQuadraticRoots, it finds roots of x^2+x+1 to be (null,null), and x^2+x-1 to be (-1+phi, -1-phi)`() {
        assertEquals(Pair(null, null), realQuadraticRoots(1.0, 1.0, 1.0))
        assertEquals(Pair(0.6180339887498949,  -1.618033988749895), realQuadraticRoots(1.0, 1.0, -1.0))
    }
    @Test
    fun `realQuadraticRoots, it finds roots of (x-3)(2x+4) to be (3, -2)`() {
        assertEquals(Pair(3.0, -2.0), realQuadraticRoots(2.0, -2.0, -12.0))
    }
    @Test
    fun `realQuadraticRoots, it finds `() {
        // (n^2 + n + 1) - 17297280 = 0
        assertEquals(Pair(3.0, -2.0), realQuadraticRoots(1.0, 1.0, (17297280 * 2).toDouble()))
        val x = 4
    }

    @Test
    fun `factorial, it finds factorial of first 5 numbers correctly`() {
        assertEquals(1, factorial(1))
        assertEquals(2, factorial(2))
        assertEquals(6, factorial(3))
        assertEquals(24, factorial(4))
        assertEquals(120, factorial(5))
    }
    @Test
    fun `bigFactorial, it finds factorial of first 5 numbers correctly`() {
        assertEquals(BigInteger.valueOf(1), bigFactorial(1))
        assertEquals(BigInteger.valueOf(2), bigFactorial(2))
        assertEquals(BigInteger.valueOf(6), bigFactorial(3))
        assertEquals(BigInteger.valueOf(24), bigFactorial(4))
        assertEquals(BigInteger.valueOf(120), bigFactorial(5))
    }
    @Test
    fun `bigFactorial, it finds factorial of 100 correctly`() {
        assertEquals(BigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"), bigFactorial(100))
    }
}