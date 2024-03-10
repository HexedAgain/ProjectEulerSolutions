package solutions.problem14

import extensions.isEven
import solutions.OneArgSolution
import solutions.problem14.LongestCollatzChain.MaxChain

@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class LongestCollatzChain: OneArgSolution<Long, MaxChain> {
    override val problemNumber = 14
    override val problemName = "Longest Collatz Chain"

    data class MaxChain(
        val index: Int,
        val length: Int
    )
    private var maxChain = MaxChain(1, 4)

    private val knownChainLengths = mutableMapOf(1L to 4L, 2L to 2L)
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
