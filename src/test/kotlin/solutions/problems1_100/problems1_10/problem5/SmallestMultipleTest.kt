package solutions.problems1_100.problems1_10.problem5

import junit.framework.TestCase.assertEquals
import org.junit.Test

class SmallestMultipleTest {
    @Test
    fun `smallestMultiple, for numbers up to 10 it finds the smallest multiple to be 2520`() {
        assertEquals(2520, SmallestMultiple().smallestMultiple(numbersUpTo = 10))
    }
    @Test
    fun `solve, for numbers up to 20 it finds the expected answer of 232792560`() {
        assertEquals(232792560, SmallestMultiple().solve())
    }
}