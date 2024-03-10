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
        
        There are some ways to generate pythagorean triplets - wikipedia says that starting from 5, every 2nd one is the
        largest side of such a triangle, and so we can try to fix one of the sides at (5, 13, 34, 89, ...), we can also
        try multiples of these
        Formula to exploit here is (F_nF_(n+3))^2 + (2F_(n+1)F_(n+2))^2 = F_(2n+3)^2
        So for example if we take 5th Fibonacci number (5), then
            c = 5, a = F_1F_4 = 1*3 = 3, b = 2F_2F_3 = 2*1*2  = 4
        if we take 7th Fibonacci number (13), then
            c = 13, a = F_2F_5 = 1*5 = 3, b = 2F_3F_4 = 2*2*3 = 12
    """.trimIndent()

    override fun solve(): Int {
        TODO("Not yet implemented")
    }
}