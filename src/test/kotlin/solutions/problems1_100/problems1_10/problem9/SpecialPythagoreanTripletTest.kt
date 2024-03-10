package solutions.problems1_100.problems1_10.problem9

import org.junit.Assert.*
import org.junit.Test
import utils.numbers.fib

class SpecialPythagoreanTripletTest {
    @Test
    fun `solve, it finds the correct answer`() {
        // Nothing really much to test. This was found by analysis and so solve just multiplies 3 numbers
        assertEquals(31875000, SpecialPythagoreanTriplet().solve())
    }
}