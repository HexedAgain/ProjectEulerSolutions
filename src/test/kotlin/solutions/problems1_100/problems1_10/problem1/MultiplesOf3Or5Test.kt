package solutions.problems1_100.problems1_10.problem1

import org.junit.Test
import solutions.problems1_100.problems1_10.problem1.MultiplesOf3Or5
import kotlin.test.assertEquals

class MultiplesOf3Or5Test {
    @Test
    fun `multiplesUpToN, if n less than 3 it returns 0`() {
        assertEquals(0, MultiplesOf3Or5().multiplesUpToN(max = 1))
        assertEquals(0, MultiplesOf3Or5().multiplesUpToN(max = 2))
    }

    @Test
    fun `multiplesUpToN, if n is 3 or 4 it returns 3`() {
        assertEquals(3, MultiplesOf3Or5().multiplesUpToN(max = 3))
        assertEquals(3, MultiplesOf3Or5().multiplesUpToN(max = 4))
    }

    @Test
    fun `multiplesUpToN, if n is 5 it returns 8`() {
        assertEquals(8, MultiplesOf3Or5().multiplesUpToN(max = 5))
    }

    @Test
    fun `multiplesUpToN, if n is 9 it returns 23`() {
        assertEquals(23, MultiplesOf3Or5().multiplesUpToN(max = 9))
    }

    @Test
    fun `solve, it returns 233168`() {
        assertEquals(233168, MultiplesOf3Or5().solve())
    }
}