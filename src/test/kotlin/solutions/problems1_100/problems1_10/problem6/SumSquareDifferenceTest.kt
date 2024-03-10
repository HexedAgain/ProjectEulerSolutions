package solutions.problems1_100.problems1_10.problem6

import org.junit.Assert.assertEquals
import org.junit.Test

class SumSquareDifferenceTest {
    @Test
    fun `squareDifference, for numbers up to 2 it returns 9 - 5 = 4`() {
        assertEquals(4, SumSquareDifference().squareDifference(numbersUpto = 2))
    }
    @Test
    fun `squareDifference, for numbers up to ten it returns 2640`() {
        assertEquals(2640, SumSquareDifference().squareDifference(numbersUpto = 10))
    }
    @Test
    fun `solve, it returns the expected answer`() {
        assertEquals(25164150, SumSquareDifference().solve())
    }
}