package solutions.problems1_100.problems11_20.problem15

import org.junit.Assert.*
import kotlin.test.Test

class LatticePathsTest {
    @Test
    fun `findPaths, it finds 2 paths on a grid of 1 rows and 1 columns`() {
        assertEquals(2, LatticePaths().findPaths(numRows = 1, numColumns = 1))
    }
    @Test
    fun `findPaths, it finds 3 paths on a grid of 1 rows and 2 columns`() {
        assertEquals(3, LatticePaths().findPaths(numRows = 1, numColumns = 2))
    }
    @Test
    fun `findPaths, it finds 6 paths on a grid of 2 rows and 2 columns`() {
        assertEquals(6, LatticePaths().findPaths(numRows = 2, numColumns = 2))
    }
    @Test
    fun `findPaths, it finds 20 paths on a grid of 3 rows and 3 columns`() {
        assertEquals(20, LatticePaths().findPaths(numRows = 3, numColumns = 3))
    }
    @Test
    fun `solve, it finds 137846528820 paths on a grid of 20 rows and 20 columns`() {
        assertEquals(137846528820, LatticePaths().findPaths(numRows = 20, numColumns = 20))
    }
}