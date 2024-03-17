package solutions.problems1_100.problems11_20.problem13

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.test.assertFailsWith

class LargeSumTest {
    @Test
    fun `firstNLines, if nDigits exceeds 10 it throws an exception`() {
        assertFailsWith(IllegalStateException::class, "expected an IllegalStateException") { LargeSum().firstNLines(nLines = 1, nDigits = 11) }
    }
    @Test
    fun `firstNLines, if nLines exceeds 100 it throws an exception`() {
        assertFailsWith(IllegalStateException::class, "expected an IllegalStateException") { LargeSum().firstNLines(nLines = 101, nDigits = 1) }
    }
    @Test
    fun `firstNLines, it calculates the first digit of the sum of first 2 lines`() {
        // 3 7 107287533902102798797998220837590246510135740250
        // 4 6 376937677490009712648124896970078050417018260538
        assertEquals(8, LargeSum().firstNLines(nLines = 2, nDigits = 1))
    }
    @Test
    fun `firstNLines, it calculates the first 10 digits of the sum of first 2 lines`() {
        // 3710728753 3 902102798797998220837590246510135740250
        // 4637693767 7 490009712648124896970078050417018260538
        assertEquals(8348422521, LargeSum().firstNLines(nLines = 2, nDigits = 10))
    }
    @Test
    fun `solve, it calculates the first 10 digits of the sum of all 50 lines`() {
        assertEquals(5537376230, LargeSum().solve())
    }
}