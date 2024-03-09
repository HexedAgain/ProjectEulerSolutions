package utils.primes

import junit.framework.Assert.assertEquals
import org.junit.Test
import java.io.File
import java.lang.Integer.parseInt

class PrimeSieveTest {
    @Test
    fun `if maxPrime is negative or zero it returns empty list`() {
        assertEquals(emptyList<Int>(), PrimeSieve(maxPrime = -123).sieve())
        assertEquals(emptyList<Int>(), PrimeSieve(maxPrime = 0).sieve())
    }

    @Test
    fun `if maxPrime is one, it returns empty list`() {
        assertEquals(emptyList<Int>(), PrimeSieve(maxPrime = 1).sieve())
    }

    @Test
    fun `if maxPrime is 2, it returns the list (2)`() {
        assertEquals(listOf(2), PrimeSieve(maxPrime = 2).sieve())
    }

    @Test
    fun `if maxPrime is 3, it returns the list (2, 3)`() {
        assertEquals(listOf(2, 3), PrimeSieve(maxPrime = 3).sieve())
    }

    @Test
    fun `if maxPrime is 10, it returns the list (2, 3, 5, 7)`() {
        assertEquals(listOf(2, 3, 5, 7), PrimeSieve(maxPrime = 10).sieve())
    }

    @Test
    fun `if maxPrime is 20, it returns the list (2, 3, 5, 7, 11, 13, 17, 19)`() {
        assertEquals(listOf(2, 3, 5, 7, 11, 13, 17, 19), PrimeSieve(maxPrime = 20).sieve())
    }

    @Test
    fun `if maxPrime is 100, it returns the known list of primes upto 100`() {
        val knownPrimes = loadPrimesList("primes100.txt")
        assertEquals(knownPrimes, PrimeSieve(maxPrime = 100).sieve())
    }
    @Test
    fun `if maxPrime is 1000_000, it returns the known list of primes upto 1000_000`() {
        val knownPrimes = loadPrimesList("primes1000_000.txt")
        assertEquals(knownPrimes, PrimeSieve(maxPrime = 1000_000).sieve())
    }

    private fun loadPrimesList(fileName: String): List<Int> {
        val dirPath = File("").canonicalPath
        val actualPath = listOf(dirPath, "src", "test", "kotlin", "utils", "primes", fileName).joinToString(File.separator)
        val reader = File(actualPath).bufferedReader()
        return reader.readLine().split(",").map { parseInt(it) }
    }
}