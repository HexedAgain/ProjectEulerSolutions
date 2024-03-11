package solutions.problems1_100.problems11_20.problem11

import solutions.NoArgSolution

class LargestProductInAGrid: NoArgSolution<Int> {
    override val problemNumber = 11
    override val problemName = "Largest Product In A Grid"
    override val problemNotes = """
        
    """.trimIndent()

    override fun solve(): Int {
        val grid = loadResourceFile(filename = "problem11.txt")
        return 0
    }
}