package solutions.problems1_100.problems11_20.problem16

import solutions.NoArgSolution
import java.math.BigInteger

/*
    2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
    What is the sum of the digits of the number 2^1000?
 */
class PowerDigitSum: NoArgSolution<Int> {
    override val problemNumber = 16
    override val problemName = "Power Digit Sum"
    override val problemNotes = """
        Trying to compute 2^1000 exactly is gonna require use of a BigInteger as it will overflow a long (and the significand
        of a double will not contain all the digits).
        If we knew 2^500 we would square it to get 2^1000, so if we knew 2^125 we could square 3 times to get 2^1000
        We can get 2^125 by (2^25)^5. Computing these I guess could be done manually but is error prone
        Haven't spotted any pattern to exploit in: 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384,...
        
        Feels like a bit of a cheat to use BigInt :(
    """.trimIndent()

    override fun solve(): Int {
        return 0
    }

    fun sumDigitsOf2PowN(n: Int): Int {
        val bigN2 = BigInteger.valueOf(2L)
        val pow2N = bigN2.pow(n)
        return pow2N.toString(10).map { it.toString().toInt() }.sum()
    }
}