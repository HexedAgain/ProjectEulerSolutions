package solutions.problems1_100.problems11_20.problem17

import solutions.NoArgSolution

/*
    If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
    If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
    NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen)
    contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
 */
class NumberLetterCounts: NoArgSolution<Int> {
    override val problemNumber = 17
    override val problemName = "Number Letter Counts"
    override val problemNotes = """
        Build a map of simple numbers and compound number elements.
        From 1-9 its <s-digit>
        From 10-19 its <teen>
        from 20-99 its the <d-digit><s-digit>
        from 100 onwards its <s-digit><hundred><and> the same as for the double digits
        
        Note: this one was horrible, so easy to get bogged down if you mapped a word wrong!
    """.trimIndent()

    val more = """
        eleven 6
        twelve 6
        thirteen 8
        fourteen 8
        fifteen 7
        sixteen 7
        seventeen 9
        eighteen 8
        nineteen 8
       
    """

    val singleDigitMap = mapOf(1 to 3, 2 to 3, 3 to 5, 4 to 4, 5 to 4, 6 to 3, 7 to 5, 8 to 5, 9 to 4)
    val teenMap = mapOf(10 to 3, 11 to 6, 12 to 6, 13 to 8, 14 to 8, 15 to 7, 16 to 7, 17 to 9, 18 to 8, 19 to 8)
    val doubleDigitMap = mapOf(20 to 6, 30 to 6, 40 to 5, 50 to 5, 60 to 5, 70 to 7, 80 to 6, 90 to 6)
    val and = 3
    val hundred = 7
    val thousand = 8

    override fun solve(): Int {
        return sumLetterCounts(1, 1000)
    }

    internal fun letterCounts(number: Int): Int {
        val numberMod100 = number % 100
        val numberMod10 = number % 10
        val numberDiv100 = number / 100
        val numberDiv1000 = number / 1000
        var sum = when {
            numberMod100 < 10 -> singleDigitMap.getOrDefault(numberMod100, 0)
            numberMod100 < 20 -> teenMap.getOrDefault(numberMod100, 0)
            else -> doubleDigitMap.getOrDefault(numberMod100 - numberMod10, 0) + singleDigitMap.getOrDefault(numberMod10, 0)
        }
        sum += when {
            number < 100 -> 0
            number < 1000 && number % 100 == 0 -> singleDigitMap.getOrDefault(numberDiv100, 0) + hundred
            number < 1000 -> singleDigitMap.getOrDefault(numberDiv100, 0) + hundred + and
            else -> 0
        }
        sum += when {
            number < 1000 -> 0
            number % 1000 == 0 -> singleDigitMap.getOrDefault(numberDiv1000, 0) + thousand
            else -> singleDigitMap.getOrDefault(numberDiv1000, 0) + thousand + and
        }
        return sum
    }

    internal fun sumLetterCounts(from: Int = 1, numbersUpTo: Int): Int {
        return (from..numbersUpTo).sumOf { letterCounts(it) }
    }
}