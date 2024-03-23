package solutions.problems1_100.problems21_30.problem21

import org.junit.Assert.*
import org.junit.Test

class AmicableNumbersTest {
    @Test
    fun `d(n), it returns the sum of proper divisors of 1 as zero`() {
        assertEquals(0, AmicableNumbers().d(1))
    }
    @Test
    fun `d(n), it returns the sum of proper divisors of 10 as 8`() {
        assertEquals(8, AmicableNumbers().d(10))
    }

    @Test
    fun `isAmicable, it reports 220 to be an amicable number`() {
        assertEquals(true, AmicableNumbers().isAmicable(220))
    }
    @Test
    fun `isAmicable, it reports 221 to not be an amicable number`() {
        assertEquals(false, AmicableNumbers().isAmicable(221))
    }
    @Test
    fun `isAmicable, it reports 6 to not be an amicable number`() {
        assertEquals(false, AmicableNumbers().isAmicable(6))
    }
    @Test
    fun `isAmicable, it reports 1 to not be an amicable number`() {
        assertEquals(false, AmicableNumbers().isAmicable(1))
    }

    @Test
    fun `allAmicable, for n in 1 to 220 it returns list of (220)`() {
        assertEquals(listOf(220), AmicableNumbers().allAmicable(upto = 224))
    }
    @Test
    fun `allAmicable, for n in 1 to 300 it returns list of (220, 284)`() {
        assertEquals(listOf(220, 284), AmicableNumbers().allAmicable(upto = 300))
    }

    @Test
    fun `solve, it returns expected answer of 31626`() {
        assertEquals(31626, AmicableNumbers().solve())
    }
}