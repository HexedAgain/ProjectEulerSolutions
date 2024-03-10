package solutions.problems1_100.problems1_10.problem8

import org.junit.Test
import utils.io.FileUtils
import kotlin.test.assertEquals

class LargestProductInSeriesTest {
    @Test
    fun `findAdjacentProduct, it finds the greatest product of 2 adjacent digits to be 81`() {
        assertEquals(81, LargestProductInSeries().findAdjacentProduct(numAdjacent = 2))
    }
    @Test
    fun `findAdjacentProduct, it finds the greatest product of 3 adjacent digits (9,9,8) to be 648`() {
        assertEquals(648, LargestProductInSeries().findAdjacentProduct(numAdjacent = 3))
    }
    @Test
    fun `solve, it finds the greatest product of 13 adjacent digits`() {
        assertEquals(23514624000, LargestProductInSeries().findAdjacentProduct(numAdjacent = 13))
    }
}