package solutions.problems1_100.problems21_30.problem22

import org.junit.Assert.*
import org.junit.Test

class NamesScoresTest {
    @Test
    fun `wordValue, it calculates A with quotes as 1`() {
        assertEquals(1, NamesScores().wordValue("\"A\""))
    }
    @Test
    fun `wordValue, it calculates abc as 6`() {
        assertEquals(6, NamesScores().wordValue("abc"))
    }

    @Test
    fun `allWordValues, it calculates (B, A) as 1 x 1 + 2 x 2 = 5`() {
        assertEquals(5, NamesScores().allWordValues(listOf("B", "A")))
    }

    @Test
    fun `allWordValues, it calculates (BC, DEF, A) as 1 x 1 + 2 x (2+3) + 3 x (4 + 5 + 6) = 56`() {
        assertEquals(56, NamesScores().allWordValues( listOf("BC", "DEF", "A")))
    }

    @Test
    fun `solve, it calculates the sum of all words in file correctly`() {
        assertEquals(871198282, NamesScores().solve())
    }
}