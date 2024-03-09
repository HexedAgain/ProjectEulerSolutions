package utils.primes

import extensions.isOdd
import junit.framework.TestCase.assertFalse
import org.junit.Assert.fail
import kotlin.math.sqrt
import kotlin.test.Test
import kotlin.test.assertTrue

class PrimeCheckerTest {
    @Test
    fun `if n is 1 it returns false`() {
        assertFalse(PrimeChecker().checkPrime(1))
    }
    @Test
    fun `if n is negative or zero it returns false`() {
        assertFalse(PrimeChecker().checkPrime(-123))
        assertFalse(PrimeChecker().checkPrime(0))
    }
    @Test
    fun `if n is a small prime it returns true`() {
        val smallPrimes = PrimeSieve(maxPrime = 1000).sieve()
        smallPrimes.forEach {
            assertTrue(PrimeChecker().checkPrime(it))
        }
    }
    @Test
    fun `for all odd composite numbers between 3 and 100_000 it returns false`() {
        val primesLT100_000 = PrimeSieve(maxPrime = 100_000).sieve()
        val nonPrimes = (1..100_000).filter { !primesLT100_000.contains(it) && it.isOdd() }
        val primeChecker = PrimeChecker()
        nonPrimes.forEach {
            print(it)
            assertFalse(primeChecker.checkPrime(it))
        }
    }
    @Test
    fun `for all odd composite numbers between 100_001 and 200_000 it returns false`() {
        val primesLT200_000 = PrimeSieve(maxPrime = 200_000).sieve()
        val nonPrimes = (100_001..200_000).filter { !primesLT200_000.contains(it) && it.isOdd() }
        val primeChecker = PrimeChecker()
        nonPrimes.forEach {
            assertFalse(primeChecker.checkPrime(it))
        }
    }
    @Test
    fun `for all odd composite numbers between 200_001 and 300_000 it returns false`() {
        val primesLT300_000 = PrimeSieve(maxPrime = 300_000).sieve()
        val nonPrimes = (200_001..300_000).filter { !primesLT300_000.contains(it) && it.isOdd() }
        val primeChecker = PrimeChecker()
        nonPrimes.forEach {
            assertFalse(primeChecker.checkPrime(it))
        }
    }
    @Test
    fun `for all odd composite numbers between 300_001 and 400_000 it returns false`() {
        val primesLT400_000 = PrimeSieve(maxPrime = 400_000).sieve()
        val nonPrimes = (300_001..400_000).filter { !primesLT400_000.contains(it) && it.isOdd() }
        val primeChecker = PrimeChecker()
        nonPrimes.forEach {
            assertFalse(primeChecker.checkPrime(it))
        }
    }
    @Test
    fun `for all odd composite numbers between 400_001 and 500_000 it returns false`() {
        val primesLT500_000 = PrimeSieve(maxPrime = 500_000).sieve()
        val nonPrimes = (400_001..500_000).filter { !primesLT500_000.contains(it) && it.isOdd() }
        val primeChecker = PrimeChecker()
        nonPrimes.forEach {
            assertFalse(primeChecker.checkPrime(it))
        }
    }

    @Test
    fun `if n is product of 2 prime numbers greater than 1000 and checker is primed with the sqrt of this composite, it returns false`() {
        val composite = 1022117
        assertFalse(PrimeChecker(maxSmallPrime = sqrt(composite.toDouble()).toInt()).checkPrime(composite))
    }
    @Test
    fun `if n is product of 2 prime numbers greater than 1000 and checker not primed, it throws an exception`() {
        val composite = 1022117
        try {
            PrimeChecker().checkPrime(composite)
            fail("did not throw exception")
        } catch (_: IllegalStateException) {}
    }
}