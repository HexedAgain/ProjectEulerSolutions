package solutions.problem14

import junit.framework.TestCase.assertEquals
import org.junit.Test
import solutions.problem14.LongestCollatzChain.MaxChain

class LongestCollatzChainTest {
    private val longestCollatzChain = LongestCollatzChain()
    @Test
    fun `if max is zero, it returns max length of 0`() {
        assertEquals(MaxChain(index = 0, length = 0), longestCollatzChain.solve(0))
    }

    @Test
    fun `if max is negative, it returns max length of 0`() {
        assertEquals(MaxChain(index = 0, length = 0), longestCollatzChain.solve(-123))
    }

    @Test
    fun `if max is 1, it returns max length of 4 with associated index 1`() {
        assertEquals(MaxChain(index = 1, length = 4), longestCollatzChain.solve(1))
    }

    @Test
    fun `if max is 3, it returns max length of 8 (3 - 10 - 5 - 16 - 8 - 4 - 2 - 1) with associated index 3`() {
        assertEquals(MaxChain(index = 3, length = 8), longestCollatzChain.solve(3))
    }

    @Test
    fun `if max is 1000_000, it returns max length of 525, with associated index 837799`() {
        assertEquals(MaxChain(index = 837799, length = 525), longestCollatzChain.solve(1000_000))
    }
}
