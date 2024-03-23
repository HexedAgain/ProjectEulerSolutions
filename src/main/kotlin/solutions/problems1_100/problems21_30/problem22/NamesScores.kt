package solutions.problems1_100.problems21_30.problem22

import solutions.NoArgSolution

/*
    Using problem22.txt, a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical
    order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the
    list to obtain a name score.

    For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the
    938th name in the list. So, COLIN would obtain a score of 938 x 53 = 49714. What is the total of all the name scores
    in the file?
 */
class NamesScores: NoArgSolution<Long> {
    override fun solve(): Long {
        val words = loadResourceFile("problem22.txt")
        return allWordValues(words.first().split(","))
    }

    override val problemNumber = 22
    override val problemName = "Names Scores"
    override val problemNotes = """
        The costliest part of all this is going to be the sorting aspect of it. If we can form an ordered list, and find
        the alphabetical value of the word then we just multiply each by position
    """.trimIndent()

    fun wordValue(word: String): Long {
        return word.replace("\"","").uppercase().map { it.code - 64L }.sum()
    }

    fun allWordValues(words: List<String>): Long {
        return words.sorted().mapIndexed { idx, word -> (idx + 1) * wordValue(word) }.sum()
    }
}