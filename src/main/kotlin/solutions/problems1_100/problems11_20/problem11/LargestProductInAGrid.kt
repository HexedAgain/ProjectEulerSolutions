package solutions.problems1_100.problems11_20.problem11

import solutions.NoArgSolution
import kotlin.math.max

class LargestProductInAGrid(private val numAdjacent: Int): NoArgSolution<Int> {
    override val problemNumber = 11
    override val problemName = "Largest Product In A Grid"
    override val problemNotes = """
        This one is similar to problem 8, albeit the search is now horizontal, vertical, and diagonal. It does not wrap
        around like 8 though so we should just to maintain an array of arrays of ints
        For horizontal, looping through each row, we hold the row index and scan the columns like we did in problem 8
        For vertical, looping through each column, we hold the column index and scan the rows (so if index was i, j
        above we just reverse the roles)
        For diagonal we have two directions: / and \. Here we are going to be holding row + col constant. I.e. if we're
        scanning the 5th diagonal / from top left then we will visit (4, 0), (3, 1), (2, 2), (1, 3), (0, 4)
        
        It is convenient to reduce 4 directions down to 2 directions by transposing the grid in 2 of these cases.
        Bit of a performance hit, but doing that we solve a single horizontal problem, and a single diagonal problem
    """.trimIndent()

    private var largestProduct = 0
    override fun solve(): Int {
        return 0
    }

    internal fun findMaxAdjacentProduct(numAdjacent: Int): Int {
        val grid = loadResourceFile(filename = "problem11.txt")
            .map { row -> row.split(" ").map { Integer.parseInt(it) } }
        var largestProduct = 0
        return 0
    }

    private fun transposeGrid(grid: List<List<Int>>): List<List<Int>> {
        val newGrid = mutableListOf<List<Int>>()
        (0 until grid.first().size).map { col ->
            newGrid.add(grid.indices.map { row -> grid[row][col] })
        }
        return newGrid
    }

    internal fun scanHorizontal(grid: List<List<Int>>): Int {
        (0 until grid.size).forEach { row ->
            var product = 1
            var divideSkips = numAdjacent
            (0 until grid.first().size).forEach { col ->
                when {
                    grid[row][col] == 0 -> {
                        product = 1
                        divideSkips = numAdjacent
                    }
                    divideSkips > 0 -> {
                        product *= grid[row][col]
                        divideSkips--
                    }
                    else -> {
                        product /= grid[row][col - numAdjacent]
                        product *= grid[row][col]
                        largestProduct = max(product, largestProduct)
                    }
                }
            }
        }
        return largestProduct
    }

    internal fun scanNorthWest(grid: List<List<Int>>): Int {
        return 0
    }

    internal fun scanVertical(grid: List<List<Int>>): Int {
        val transposed = transposeGrid(grid)
        return scanHorizontal(transposed)
    }

    private fun scanDiagonal(grid: List<List<Int>>, numAdjacent: Int): Int {
        return 0
    }
//    var product = 0
//    while (product == 0 && i + numAdjacent < row.size) {
//        product = row.take(numAdjacent).reduce { acc, i -> i * acc }
//        i += 1
//    }
//    largestProduct = max(product, largestProduct)
//    (i until row.size - numAdjacent).forEach {
//        product = (product / row[it]) * row[it + numAdjacent]
//        largestProduct = max(product, largestProduct)
//    }
}