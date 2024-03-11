package solutions.problems1_100.problems11_20.problem11

import org.junit.Assert.*
import org.junit.Test

class LargestProductInAGridTest {
    private val grid = LargestProductInAGrid().loadResourceFile("problem11.txt")
        .map { row -> row.split(" ").map { Integer.parseInt(it) } }
    @Test
    fun `scanHorizontal, for a simple grid if numAdjacent is 2, it finds 2 x 4`() {
        val grid = listOf(listOf(1, 2, 3, 0, 9, 0, 2, 4, 2, 4)) // 9 here is a decoy
        assertEquals(8, LargestProductInAGrid().scanHorizontal(grid = grid, numAdjacent = 2))
    }
    @Test
    fun `scanHorizontal, for first row in real grid and numAdjacent 4, it finds 12 x 50 x 77 x 91`() {
        val grid = listOf(grid.first())
        assertEquals(4204200, LargestProductInAGrid().scanHorizontal(grid = grid, numAdjacent = 4))
    }
    @Test
    fun `scanHorizontal, for all rows in real grid and numAdjacent 4, it finds 78 x 78 x 96 x 83`() {
        val grid = grid
        assertEquals(48477312, LargestProductInAGrid().scanHorizontal(grid = grid, numAdjacent = 4))
    }

    @Test
    fun `findMaxAdjacentProduct, if numAdjacent is 2, it finds 99 times 94 (on the diagonal)`() {
        assertEquals(99 * 94, LargestProductInAGrid().findMaxAdjacentProduct(numAdjacent = 2))
    }
}