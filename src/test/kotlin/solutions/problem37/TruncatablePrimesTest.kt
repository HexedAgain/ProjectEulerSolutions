package solutions.problem37

import junit.framework.Assert.assertEquals
import org.junit.Test
import solutions.project37.TruncatablePrimes


class TruncatablePrimesTest {
    @Test
    fun `if max primes is 1, it returns 23`() {
        val result = TruncatablePrimes().solve(1)

        assertEquals(23, result)
    }

    @Test
    fun `if max primes is 2, it returns 55 = 23 + 32`() {
        val result = TruncatablePrimes().solve(2)

        assertEquals(55, result)
    }
}