package solutions.problems1_100.problems1_10.problem9

import solutions.NoArgSolution

/*
    A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
        a^2 + b^2 = c^2.
    For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
    There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the product abc.
 */
class SpecialPythagoreanTriplet: NoArgSolution<Int> {
    override val problemNumber = 9
    override val problemName = "Special Pythagorean Triplet"
    override val problemNotes = """
        We need to find a triplet satisfying equation: a + b + c = 1000. A kind of brute force attack on this one
        is to first fix a, b, then loop through c and check if its a triple. Then vary a, b, and play the same game
        until we finished. The value of a, b, will put an upper bound on c.
        From the form of the equation we know that either all 3 squares are even, or one square is even. (Since if an
        odd number of odd squares will add to an odd number =/= 1000).
    """.trimIndent()

    override fun solve(): Int {
        TODO("Not yet implemented")
    }
}