package solutions.problems1_100.problems11_20.problem20

import org.junit.Assert.*
import kotlin.test.Test

class FactorialDigitSumTest {
    @Test
    fun `sumFactorialDigits it finds the digit sum of 1 factorial to be 1`() {
        assertEquals(1, FactorialDigitSum().sumFactorialDigits(factorialDigit = 1))
    }
    @Test
    fun `sumFactorialDigits it finds the digit sum of 4 factorial to be 6`() {
        assertEquals(6, FactorialDigitSum().sumFactorialDigits(factorialDigit = 4))
    }
    @Test
    fun `sumFactorialDigits it finds the digit sum of 10 factorial to be 27`() {
        assertEquals(27, FactorialDigitSum().sumFactorialDigits(factorialDigit = 10))
    }
    @Test
    fun `sumFactorialDigits it finds the digit sum of 100 factorial to be 648`() {
        assertEquals(648, FactorialDigitSum().sumFactorialDigits(factorialDigit = 100))
    }
}