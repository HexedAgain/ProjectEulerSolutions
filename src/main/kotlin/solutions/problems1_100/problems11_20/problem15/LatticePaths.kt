package solutions.problems1_100.problems11_20.problem15

import solutions.NoArgSolution

/*
    Starting in the top left corner of a 2x2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.

            *****  ***    ***    *      *      *
                *    ***    *    *****  ***    *
                *      *    ***      *    ***  *****

    How many such routes are there through a 20 x 20 grid
 */
class LatticePaths: NoArgSolution<Long> {
    override fun solve(): Long {
        return 0L
    }

    override val problemNumber = 15
    override val problemName = "Lattice Paths"
    override val problemNotes = """
        If we had a 1x1 grid, there would be 2 routes through it, one where we go horizontal then vertical or the other
        where we go vertical and then horizontal.
        Now suppose it was a 1 x 2 grid. If we go horizontal, we are then in the same situation as for a 1x1 grid, and
        if we go first vertical we have only one route, so now the answer is 3 routes
        For an 1 x N there are N+1 nodes, N of these you have a choice to continue horizontal or to instead go vertical.
        So there are N + 1 routes.
        Now consider a 2 x N grid, if you immediately go vertical then you're in the 1xN grid situation, if you first
        go horizontal followed by vertical you're in the 1x(N-1) grid situation, and so on. As such the number of solutions
        is Sum(1 + N, N, 1-N, ... 1) = (N+1)(N+2)/2
        In general M x N can be computed so long as we have previously computed (M-1)x(N-a) for a in (N-1..0).
        There for a reasonably efficient solution would be to systematically construct a map of solutions for each row
    """.trimIndent()

    private val rowCols = MutableList(size = 21) { MutableList(size = 21) { 0L } }
    fun findPaths(numRows: Int, numColumns: Int): Long {
        (0..numColumns).forEach { rowCols[0][it] = 1L }
        (1..numRows).forEach { row ->
            (0..numColumns).forEach { col ->
                rowCols[row][col] = rowCols[row - 1].subList(0, col + 1).sum()
            }
        }
        return rowCols[numRows][numColumns]
    }
}