package solutions.problems1_100.problems1_10.problem10

import org.junit.Assert.*
import org.junit.Test

class SummationOfPrimesTest {
    @Test
    fun `solve, it returns the expected solution`() {
        assertEquals(142913828922L, SummationOfPrimes().solve())
    }
}