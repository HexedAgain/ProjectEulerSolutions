package solutions.problems1_100.problems61_70.problem67

import org.junit.Assert.*
import org.junit.Test

class MaximumPathSum2Test {
    @Test
    fun `solve, it finds max path of the provided triangular grid`() {
        assertEquals(7273, MaximumPathSum2("problem67.txt").solve())
    }
}