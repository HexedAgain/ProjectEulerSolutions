package solutions.problems1_100.problems1_10.problem8

import org.junit.Test
import kotlin.test.assertEquals

class LargestProductInSeriesTest {
    @Test
    fun `findMaxAdjacentProduct, it finds the greatest product of 2 adjacent digits to be 81`() {
        assertEquals(81, LargestProductInSeries().findMaxAdjacentProduct(numAdjacent = 2))
    }
    @Test
    fun `findMaxAdjacentProduct, it finds the greatest product of 3 adjacent digits (9,9,8) to be 648`() {
        assertEquals(648, LargestProductInSeries().findMaxAdjacentProduct(numAdjacent = 3))
    }
    @Test
    fun `solve, it finds the greatest product of 13 adjacent digits`() {
        assertEquals(23514624000, LargestProductInSeries().findMaxAdjacentProduct(numAdjacent = 13))
    }
}