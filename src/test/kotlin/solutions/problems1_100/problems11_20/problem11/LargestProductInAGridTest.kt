package solutions.problems1_100.problems11_20.problem11

import org.junit.Assert.*
import org.junit.Test

class LargestProductInAGridTest {
    private val grid = LargestProductInAGrid(numAdjacent = 1).loadResourceFile("problem11.txt")
        .map { row -> row.split(" ").map { Integer.parseInt(it) } }
    @Test
    fun `scanHorizontal, for a simple grid if numAdjacent is 2, it finds 2 x 4`() {
        val grid = listOf(listOf(1, 2, 3, 0, 9, 0, 2, 4, 2, 4)) // 9 here is a decoy
        assertEquals(8, LargestProductInAGrid(numAdjacent = 2).scanHorizontal(grid = grid))
    }
    @Test
    fun `scanHorizontal, for first row in real grid and numAdjacent 4, it finds 12 x 50 x 77 x 91`() {
        val grid = listOf(grid.first())
        assertEquals(4204200, LargestProductInAGrid(numAdjacent = 4).scanHorizontal(grid = grid))
    }
    @Test
    fun `scanHorizontal, for all rows in real grid and numAdjacent 4, it finds 78 x 78 x 96 x 83`() {
        val grid = grid
        assertEquals(48477312, LargestProductInAGrid(numAdjacent = 4).scanHorizontal(grid = grid))
    }

    @Test
    fun `scanVertical, for first column in real grid and numAdjacent 4, it finds 49 x 81 x 52 x 22`() {
        val grid = grid.map { it.take(1) }
        assertEquals(4540536, LargestProductInAGrid(numAdjacent = 4).scanVertical(grid = grid))
    }
    @Test
    fun `scanVertical, for all columns in real grid and numAdjacent 4, it finds 66 x 91 x 88 x 97`() {
        val grid = grid
        assertEquals(51267216, LargestProductInAGrid(numAdjacent = 4).scanVertical(grid = grid))
    }

    @Test
    fun `scanNorthWest, for all columns in real grid and numAdjacent 4, it finds 87 x 97 x 94 x 89`() {
        val grid = grid
        assertEquals(70600674, LargestProductInAGrid(numAdjacent = 4).scanNorthWest(grid = grid))
    }
    @Test
    fun `scanNorthEast, for all columns in real grid and numAdjacent 4, it finds 49 x 95 x 71 x 99`() {
        val grid = grid
        assertEquals(32719995, LargestProductInAGrid(numAdjacent = 4).scanNorthEast(grid = grid))
    }

    @Test
    fun `solve, if finds expected answer on northwest diagonal`() {
        assertEquals(70600674, LargestProductInAGrid(numAdjacent = 4).solve())
    }
}