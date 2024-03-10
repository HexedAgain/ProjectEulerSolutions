package solutions.problems1_100.problems1_10.problem7

import org.junit.Assert.*
import org.junit.Test

class Prime10001Test {
    @Test
    fun `solve, it returns the 10001st prime`() {
        assertEquals(104743, Prime10001().solve())
    }

}