package solutions.problems1_100.problems11_20.problem16

import org.junit.Assert.*
import org.junit.Test

class PowerDigitSumTest {
    @Test
    fun `sumDigitsOf2PowN, it calculates digits of pow(2,15) as 26`() {
        assertEquals(26, PowerDigitSum().sumDigitsOf2PowN(n = 15))
    }
    @Test
    fun `sumDigitsOf2PowN, it calculates digits of pow(2,1000) as 26`() {
        assertEquals(1366, PowerDigitSum().sumDigitsOf2PowN(n = 1000))
    }
}