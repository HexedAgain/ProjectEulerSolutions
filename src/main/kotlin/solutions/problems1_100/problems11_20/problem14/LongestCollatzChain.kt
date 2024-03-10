package solutions.problems1_100.problems11_20.problem14

import extensions.isEven
import solutions.OneArgSolution
import solutions.problems1_100.problems11_20.problem14.LongestCollatzChain.MaxChain

/*
    The following iterative sequence is defined for the set of positive integers:
        n -> n/2 (n is even)
        n -> 3n + 1 (n is odd)
    Using the rule above and starting with 13, we generate the following sequence:
        13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1.
    It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
    Which starting number, under one million, produces the longest chain?
    Note: Once the chain starts the terms are allowed to go above one million.
 */
@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class LongestCollatzChain: OneArgSolution<Long, MaxChain> {
    override val problemNumber = 14
    override val problemName = "Longest Collatz Chain"
    override val problemNotes = """
        If as we go along, we memoize the chain lengths, then for any new chain, once we encounter a number previously 
        remembered we can just stop and directly update new chain lengths. I.e. we can proceed iteratively like:
        1 -> 4 -> 2 -> 1: stop (update chain lengths for 1, 4, 2, 1)
        2: stop (we already encountered 2)
        3 -> 10 -> 5 -> 16 -> 8 -> 4: stop (update chain lengths for 3, 10, 5, 16, 8, 4)
        4: stop (we already encountered 4)
        5: stop (we already encountered 5)
        6 -> 3: stop (we already encountered 3)
        and so on ...
        I believe this is a quicker solution than blindly looping through each number in 1..1000_000 but there might
        also be a better implementation
    """.trimIndent()

    data class MaxChain(
        val index: Int,
        val length: Int
    )
    private var maxChain = MaxChain(1, 4)

    private val knownChainLengths = mutableMapOf(1L to 4L, 2L to 2L, 4L to 3L)
    private val chain = mutableListOf<Long>()
    // FIXME I probably need a no-arg version of this
    override fun solve(max: Long): MaxChain {
        if (max <= 0L) return MaxChain(0, 0)
        (1..max).forEach {
            if (!knownChainLengths.containsKey(it)) {
                buildCollatzChain(it, max)
            }
        }
        return maxChain
    }

    private fun buildCollatzChain(n: Long, max: Long) {
        chain.clear()
        var currentLink = n
        while (!knownChainLengths.containsKey(currentLink)) {
            chain.add(currentLink)
            currentLink = collatzRule(currentLink)
            if (currentLink < 0) throw IllegalStateException("Number overflowed")
        }
        val linkLength = knownChainLengths[currentLink] ?: 0
        chain.forEachIndexed { idx, item ->
            if (item <= max) {
                knownChainLengths[item] = chain.size - idx + linkLength
            }
        }
        val thisLength = linkLength + chain.size
        if (thisLength > maxChain.length) {
            maxChain = MaxChain(index = n.toInt(), length = thisLength.toInt())
        }
    }

    private fun collatzRule(n: Long): Long {
        return if (n.isEven()) n / 2 else 3*n + 1
    }
}
