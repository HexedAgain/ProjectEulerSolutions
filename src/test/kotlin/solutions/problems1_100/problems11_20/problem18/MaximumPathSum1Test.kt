package solutions.problems1_100.problems11_20.problem18

import org.junit.Assert.*
import org.junit.Test

class MaximumPathSum1Test {
    @Test
    fun `findMaxPath, given two trivial rows, it identifies the max path`() {
        val rows = listOf(listOf(1), listOf(2,3))
        val expected = 1 + 3

        assertEquals(expected, MaximumPathSum1().findMaxPath(rows))
    }

    @Test
    fun `findMaxPath, given two non-trivial rows, it identifies the max path`() {
        val rows = listOf(listOf(0, 4, 2, 9, 1, 3), listOf(8, 5, 1, 2, 0, 7, 9))
        val expected = 9 + 3

        assertEquals(expected, MaximumPathSum1().findMaxPath(rows))
    }

    @Test
    fun `findMaxPath, given example triangle, it finds example answer`() {
        val rows = listOf(listOf(3), listOf(7, 4), listOf(2, 4, 6), listOf(8, 5, 9, 3))
        val expected = 23

        assertEquals(expected, MaximumPathSum1().findMaxPath(rows))
    }

    @Test
    fun `solve, it finds max path of the provided triangular grid`() {
        assertEquals(1074, MaximumPathSum1().solve())
    }
}