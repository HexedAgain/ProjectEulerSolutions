package solutions.problems1_100.problems11_20.problem18

import solutions.NoArgSolution
import java.lang.Integer.max

open class MaximumPathSum1(private val problemFile: String = "problem18.txt"): NoArgSolution<Int> {
    override val problemNumber = 18
    override val problemName = "Maximum Path Sum 1"
    override val problemNotes = """
        Suppose you are at some position on the penultimate row, and you are currently on the max path; then max path to
        the bottom would be to take whichever is the largest of the two items directly below. Since we don't need to
        actually remember the path then for any item on a row, we take the sum of the two lower adjacents and work our
        way upwards
    """.trimIndent()

    override fun solve(): Int {
        val rows = loadResourceFile(problemFile).map { row -> row.split(" ").map { Integer.parseInt(it) } }
        return findMaxPath(rows)
    }

    fun findMaxPath(rows: List<List<Int>>): Int {
        val mutRows: MutableList<MutableList<Int>> = rows.map { it.toMutableList() }.toMutableList()
        (mutRows.size - 2 downTo 0).forEach { row ->
            (0 until rows[row].size).forEach { col ->
                mutRows[row][col] = mutRows[row][col] + max(mutRows[row + 1][col], mutRows[row + 1][col + 1])
            }
        }
        return mutRows[0].maxOrNull() ?: 0
    }
}