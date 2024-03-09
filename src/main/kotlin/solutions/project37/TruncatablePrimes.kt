package solutions.project37

import solutions.OneArgSolution

/*
    The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right,
    and remain prime at each stage: 3797, 797, 97, and 7. Similarly, we can work from right to left: 3797, 379, 37, and 3.
    Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
    NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */

@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class TruncatablePrimes: OneArgSolution<Int, Int> {
    override val problemNumber = 37
    override val problemName = "Truncatable Primes"

    override fun solve(max: Int): Int {
        var solutionsFound = 0
        while (solutionsFound < max) {

        }
        return 23
    }
}