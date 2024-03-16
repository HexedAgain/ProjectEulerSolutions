package solutions.problems1_100.problems11_20.problem12

import solutions.NoArgSolution
import utils.numbers.numDivisors
import utils.numbers.sum

/*
    The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be
        1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be: 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
        Let us list the factors of the first seven triangle numbers:
            1:   1
            3:   1,3
            6:   1,2,3,6
            10:  1,2,5,10
            15:  1,3,5,15
            21:  1,3,7,21
            28:  1,2,4,7,14,28
    We can see that 28 is the first triangle number to have over five divisors.
    What is the value of the first triangle number to have over five hundred divisors?
 */
class HighlyDivisibleTriangularNumber: NoArgSolution<Triple<Int, Int, Long>> {
    override val problemNumber = 12
    override val problemName = "Highly Divisible Triangular Number"
    override val problemNotes = """
        The first thing we should do is to find the first *number* to have over 500 divisors, as any triangular number
        is going to be larger than that. Consider the sequence of p prime powers
        {2^a, 3^b, ..., p^n}
        The number of divisors of their product turns out to be (a+1)(b+1)...(n+1), so this is what we want to minimise
        The smallest such product here is 2^9 = 512, so if we took the first 9 primes and found their product then the
        number of divisors would be 512. We can do better than this though as the first 9 primes are:
            2, 3, 5, 7, 11, 13, 17, 19, 23 with product 223092870
        We get a smaller number with same divisors by dividing by 23 * 19 * 17 and multiplying instead by 4 * 9 * 16 to get:
            128, 27, 5, 7, 11, 13 with product 17297280
        We can't do better than this as to divide by 13 we'd need to multiply by either 256, 81, 49, or 25
        As such we start with triangular numbers no smaller than 17297280. Solving for n in n(n+1) = 17297280 we get n = 5883
        We now loop from n = 5883 until we find a triangular number with more divisors.
        We can probably reduce work by only considering only even triangular numbers, these occur in consecutive doubles
        i.e. 6, 10, ., ., 28, 36, ., ., 66, 78, ... i.e. n = 4m or 4m-1
    """.trimIndent()

    override fun solve(): Triple<Int, Int, Long> {
        return smallestTriangular(5883, 500)
    }

    internal fun smallestTriangular(leastN: Int = 1, numDivisorsRequired: Int): Triple<Int, Int, Long> {
        var n = leastN
        while (true) {
            val sum = sum(n++).toLong()
            val numDivisors = numDivisors(sum).toInt()
            if (numDivisors > numDivisorsRequired) {
                return Triple(n-1, numDivisors, sum)
            }
        }
    }
}