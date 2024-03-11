package solutions.problems1_100.problems11_20.problem11

import solutions.NoArgSolution
import kotlin.math.max
import kotlin.math.min

class LargestProductInAGrid(private val numAdjacent: Int): NoArgSolution<Int> {
    override val problemNumber = 11
    override val problemName = "Largest Product In A Grid"
    override val problemNotes = """
        This one "looks" similar to problem 8, albeit the search is now horizontal, vertical, and diagonal. It does not
        wraparound like 8 though so we should just to maintain an array of arrays of ints
        
        It is convenient to reduce 4 directions down to 2 directions by "rotating" the grid in 2 of these cases.
        Bit of a performance hit, but doing that we solve a single horizontal problem, and a single diagonal problem
        There is a single algorithm serving both of these cases but it gets fiddly with indices ... this one was a 
        bit of a debug-fest to get right :(
    """.trimIndent()

    private var largestProduct = 0
    override fun solve(): Int {
        val grid = loadResourceFile(filename = "problem11.txt")
            .map { row -> row.split(" ").map { Integer.parseInt(it) } }

        scanHorizontal(grid)
        scanVertical(grid)
        scanNorthWest(grid)
        scanNorthEast(grid)

        return largestProduct
    }

    private fun rotateGrid(grid: List<List<Int>>): List<List<Int>> {
        val newGrid = mutableListOf<List<Int>>()
        (0 until grid.first().size).map { col ->
            newGrid.add(grid.indices.map { row -> grid[row][grid.first().size - 1 - col] })
        }
        newGrid.forEach {
            println(it)
        }
        return newGrid
    }

    internal fun scanHorizontal(grid: List<List<Int>>): Int {
        (0 until grid.size).forEach { row ->
            var product = 1
            var divideSkips = numAdjacent
            (0 until grid.first().size).forEach { col ->
                val result = innerAlgorithm(grid, row, col, product, divideSkips, false)
                product = result.first
                divideSkips = result.second
            }
        }
        return largestProduct
    }

    internal fun scanNorthWest(grid: List<List<Int>>): Int {
        (0 until (2 * grid.size - 1)).forEach { longRow ->
            var product = 1
            var divideSkips = numAdjacent
            val row = min(longRow, grid.size - 1)
            (0..(2 * row - longRow)).forEach { col ->
                val minCol = longRow - row
                val result = innerAlgorithm(grid, row - col, col + minCol, product, divideSkips, true)
                product = result.first
                divideSkips = result.second
            }
        }
        return largestProduct
    }

    internal fun scanVertical(grid: List<List<Int>>): Int {
        val transposed = rotateGrid(grid)
        return scanHorizontal(transposed)
    }

    internal fun scanNorthEast(grid: List<List<Int>>): Int {
        val transposed = rotateGrid(grid)
        return scanNorthWest(transposed)
    }

    private fun innerAlgorithm(
        grid: List<List<Int>>,
        row: Int,
        col: Int,
        product: Int,
        divideSkips: Int,
        isDiagonal: Boolean
    ): Pair<Int, Int> {
        var newProduct = product
        var newDivideSkips = divideSkips
        when {
            grid[row][col] == 0 -> {
                newProduct = 1
                newDivideSkips = numAdjacent
            }
            newDivideSkips > 0 -> {
                newProduct *= grid[row][col]
                newDivideSkips--
            }
            else -> {
                val prevRow = row + if (isDiagonal) numAdjacent else 0
                val prevCol = col - numAdjacent
                newProduct /= grid[prevRow][prevCol]
                newProduct *= grid[row][col]
                largestProduct = max(product, largestProduct)
            }
        }
        return Pair(newProduct, newDivideSkips)
    }
}