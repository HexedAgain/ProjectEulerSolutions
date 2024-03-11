package solutions.problems1_100.problems11_20.problem11

import org.junit.Assert.*
import org.junit.Test
import solutions.problems1_100.problems11_20.problem11.LargestProductInAGrid.Orientation.*

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

//    @Test
//    fun `rotate, if orientation is horizontal it returns the same grid`() {
//        val initialGrid = listOf(listOf(1,2,3), listOf(4,5,6), listOf(7,8,9))
//        val expectedGrid = initialGrid
//        assertEquals(expectedGrid, LargestProductInAGrid(numAdjacent = 1).transposeGrid(grid = initialGrid, orientation = HORIZONTAL))
//    }
//    @Test
//    fun `rotate, if orientation is vertical it transposes the grid`() {
//        val initialGrid = listOf(listOf(1,2,3), listOf(4,5,6), listOf(7,8,9))
//        val expectedGrid = listOf(listOf(1,4,7), listOf(2,5,8), listOf(3,6,9))
//        assertEquals(expectedGrid, LargestProductInAGrid(numAdjacent = 1).transposeGrid(grid = initialGrid, orientation = VERTICAL))
//    }
//    @Test
//    fun `rotate, if orientation is diagonal NW it rotates the grid counterclockwise by 45 degrees`() {
//        val initialGrid = listOf(listOf(1,2,3), listOf(4,5,6), listOf(7,8,9))
//        val expectedGrid = listOf(listOf(3), listOf(2,6), listOf(1,5,9), listOf(4,8), listOf(7))
//        assertEquals(expectedGrid, LargestProductInAGrid(numAdjacent = 1).transposeGrid(grid = initialGrid, orientation = DIAGONAL_NORTH_WEST))
//    }
//    @Test
//    fun `rotate, if orientation is diagonal NE it rotates the grid clockwise by 45 degrees`() {
//        val initialGrid = listOf(listOf(1,2,3), listOf(4,5,6), listOf(7,8,9))
//        val expectedGrid = listOf(listOf(1), listOf(4,2), listOf(7,5,3), listOf(8,6), listOf(9))
//        assertEquals(expectedGrid, LargestProductInAGrid(numAdjacent = 1).transposeGrid(grid = initialGrid, orientation = DIAGONAL_NORTH_EAST))
//    }

    @Test
    fun `findMaxAdjacentProduct, if numAdjacent is 2, it finds 99 times 94 (on the diagonal)`() {
        assertEquals(99 * 94, LargestProductInAGrid(numAdjacent = 4).findMaxAdjacentProduct(numAdjacent = 2))
    }
}