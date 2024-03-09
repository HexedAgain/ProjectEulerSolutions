package solutions.problem37

import junit.framework.Assert.assertEquals
import org.junit.Test
import solutions.project37.TruncatablePrimes


class TruncatablePrimesTest {
    @Test
    fun `bothWayTruncatablePrimes, if max prime is zero or negative, it returns emptyList`() {
        assertEquals(emptyList<Int>(), TruncatablePrimes(primesUpto = 0).getBothWayTruncatablePrimes())
        assertEquals(emptyList<Int>(), TruncatablePrimes(primesUpto = -123).getBothWayTruncatablePrimes())
    }
    @Test
    fun `bothWayTruncatablePrimes, if max prime is less than 23, it returns emptyList`() {
        (1 until 23).forEach {
            assertEquals(emptyList<Int>(), TruncatablePrimes(primesUpto = it).getBothWayTruncatablePrimes())
        }
    }

    @Test
    fun `bothWayTruncatablePrimes, if max prime is equal to 23, it returns list (23)`() {
        val result = TruncatablePrimes(primesUpto = 23).getBothWayTruncatablePrimes()

        assertEquals(listOf(23), result)
    }

    @Test
    fun `bothWayTruncatablePrimes, if max prime is 37, it returns list (23, 37)`() {
        val result = TruncatablePrimes(primesUpto = 37).getBothWayTruncatablePrimes()

        assertEquals(listOf(23, 37), result)
    }

    @Test
    fun `bothWayTruncatablePrimes, if max prime is 100, it returns list (23, 37, 53, 73)`() {
        val result = TruncatablePrimes(primesUpto = 100).getBothWayTruncatablePrimes()

        assertEquals(listOf(23, 37, 53, 73), result)
    }
    @Test
    fun `bothWayTruncatablePrimes, if max prime is 1000_000, it returns list (23, 37, 53, 73, 313, 317, 373, 797, 3137, 3797, 739397)`() {
        val result = TruncatablePrimes(primesUpto = 1000_000).getBothWayTruncatablePrimes()

        assertEquals(listOf(23, 37, 53, 73, 313, 317, 373, 797, 3137, 3797, 739397), result)
    }

    @Test
    fun `solve, it returns the sum of primes up to 1000_000 that are both way truncatable`() {
        val result = TruncatablePrimes().solve()
        assertEquals(748317, result)
    }
}