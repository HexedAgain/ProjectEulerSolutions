package solutions.problems1_100.problems11_20.problem17

import org.junit.Assert.*
import org.junit.Test

class NumberLetterCountsTest {
    @Test
    fun `letterCounts, it returns the correct counts for all numbers from 1 to 10`() {
        assertEquals(3, NumberLetterCounts().letterCounts(1))
        assertEquals(3, NumberLetterCounts().letterCounts(2))
        assertEquals(5, NumberLetterCounts().letterCounts(3))
        assertEquals(4, NumberLetterCounts().letterCounts(4))
        assertEquals(4, NumberLetterCounts().letterCounts(5))
        assertEquals(3, NumberLetterCounts().letterCounts(6))
        assertEquals(5, NumberLetterCounts().letterCounts(7))
        assertEquals(5, NumberLetterCounts().letterCounts(8))
        assertEquals(4, NumberLetterCounts().letterCounts(9))
        assertEquals(3, NumberLetterCounts().letterCounts(10))
    }

    @Test
    fun `sumLetterCounts, it returns the sum of all number letter counts from 1 to 9`() {
        assertEquals(36, NumberLetterCounts().sumLetterCounts(numbersUpTo = 9))
    }
    @Test
    fun `sumLetterCounts, it returns the sum of all number letter counts from 10 to 19`() {
        // 3 + 6 + 6 + 8 + 8 + 7 + 7 + 9 + 8 + 8 =
        assertEquals(70, NumberLetterCounts().sumLetterCounts(from = 10, numbersUpTo = 19))
    }
    @Test
    fun `sumLetterCounts, it returns the sum of all number letter counts from 100 to 110`() {
        // the two digit parts are as the 1 to 10 case, there is a single "one hundred", and 10 "one hundred and"s
        assertEquals(39 + 10 + (13 * 10), NumberLetterCounts().sumLetterCounts(from = 100, numbersUpTo = 110))
    }
    @Test
    fun `sumLetterCounts, it returns the sum of all number letter counts from 111 to 130`() {
        // we have the teens, then 1 "twenty", 9 "twenty" + single digits, a single "thirty", a single "one hundred" and 20 "one hundred and"s
        val expected = 445 // = 74 + (10 * 6) + (39 - 3) + 6 + 10 + (13 * 20)
        assertEquals(expected, NumberLetterCounts().sumLetterCounts(from = 110, numbersUpTo = 130))
    }

    @Test
    fun `sumLetterCounts, it returns the sum of all number letter counts from 1 to 99`() {
        // 1 single digits, 8 (single digits - "ten"), 1 teens, 10 ("twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"),
        val expected = 854 // 36 + 70 + (8 * 36) + 10 * (6 + 6 + 5 + 5 + 5 + 7 + 6 + 6)
        assertEquals(expected, NumberLetterCounts().sumLetterCounts(from = 1, numbersUpTo = 99))
    }
    @Test
    fun `sumLetterCounts, it returns the sum of all number letter counts from 1 to 200`() {
        // 2 1-99s, 1 "one hundred", 1 "two hundred" 99 "one hundred and"s
        val expected = 2 * 854 + 10 + 10 + 99 * 13
        assertEquals(expected, NumberLetterCounts().sumLetterCounts(from = 1, numbersUpTo = 200))
    }
    @Test
    fun `sumLetterCounts, it returns the sum of all number letter counts from 1 to 300`() {
        // 3 1-99s, 1 "one hundred", 1 "two hundred" 1 "three hundred" 99 "one hundred and"s 99 "two hundred and"s
        val expected = 3 * 854 + 10 + 10 + 12 + (99 * 13) * 2
        assertEquals(expected, NumberLetterCounts().sumLetterCounts(from = 1, numbersUpTo = 300))
    }
    @Test
    fun `sumLetterCounts, it returns the sum of all number letter counts from 1 to 400`() {
        // 4 1-99s, 1 "one hundred", 1 "two hundred" 1 "three hundred" 1 "four hundred", 99 "one hundred and"s 99 "two hundred and"s, 99 "three hundred and"s
        val expected = 4 * 854 + 10 + 10 + 12 + 11 + (99 * 13) * 2 + (15 * 99)
        assertEquals(expected, NumberLetterCounts().sumLetterCounts(from = 1, numbersUpTo = 400))
    }
    @Test
    fun `sumLetterCounts, it returns the sum of all number letter counts from 1 to 500`() {
        val expected = 9769 // = (5 * 854) + (10 + 10 + 12 + 11 + 11) + (99 * 13) * 2 + (15 * 99) + (14 * 99)
        assertEquals(expected, NumberLetterCounts().sumLetterCounts(from = 1, numbersUpTo = 500))
    }
    @Test
    fun `sumLetterCounts, it returns the sum of all number letter counts from 1 to 600`() {
        val expected = (6 * 854) + (10 + 10 + 12 + 11 + 11 + 10) + (99 * 13) * 2 + (15 * 99) + (14 * 99) * 2
        assertEquals(expected, NumberLetterCounts().sumLetterCounts(from = 1, numbersUpTo = 600))
    }

    @Test
    fun `sumLetterCounts, it returns the sum of all number letter counts from 1 to 700`() {
        val expected = (7 * 854) + (10 + 10 + 12 + 11 + 11 + 10 + 12) + (99 * 13) * 2 + (15 * 99) + (14 * 99) * 2 + (13 * 99)
        assertEquals(expected, NumberLetterCounts().sumLetterCounts(from = 1, numbersUpTo = 700))
    }

    @Test
    fun `sumLetterCounts, it returns the sum of all number letter counts from 1 to 800`() {
        val expected = (8 * 854) + (10 + 10 + 12 + 11 + 11 + 10 + 12 + 12) + (99 * 13) * 2 + (15 * 99) * 2 + (14 * 99) * 2 + (13 * 99)
        assertEquals(expected, NumberLetterCounts().sumLetterCounts(from = 1, numbersUpTo = 800))
    }

    @Test
    fun `sumLetterCounts, it returns the sum of all number letter counts from 1 to 900`() {
        val expected = (9 * 854) + (10 + 10 + 12 + 11 + 11 + 10 + 12 + 12 + 11) + ((99 * 13) * 3) + ((15 * 99) * 3) + ((14 * 99) * 2)
        assertEquals(expected, NumberLetterCounts().sumLetterCounts(from = 1, numbersUpTo = 900))
    }

    /**
     * review:
     * rayfil, I admit that I did do it in pen and paper ("well notepad really)". I have copied the text below.
     * ---
     * one 3 -two 3 -three 5 -four 4 -five 4 -six 3 -seven 5 -eight 5 -nine 4 == 36
     * ten 3 -eleven 6- twelve 6 -thirteen 8 -fourteen 8 -fifteen 7 -sixteen 7 -seventeen 9 -eighteen 8- nineteen 8 == 70
     * twenty 6 -thirty 6 -forty 5 -fifty 5 -sixty 5 -seventy 7 -eighty 6 -ninety 6 == (46 * 10)  + (36 * 8) = 460 + 288 = 748
     *
     * between 1..99 = 36 + 70 +748 = 854
     *
     * Hundred	7 ->the hundreds(100, 200, 300, 900)  7 * 9  + 36 = 63 + 36 = 99
     * hundred And = 10 ->(hundred ands = 10 * 99 * 9 = 99 * 90 = 8910  )
     * (the nuumber before word hundred) = 99 * 36 = 3564
     * numbers themselves = 9 * 854 = 7696
     * One thousand = 11
     * total sum = 854 + 99 + 8910 + 3564 + 7696 + 11
     * 		=21124
     */
    @Test
    fun `sumLetterCounts, it returns the sum of all number letter counts from 1 to 1000`() {
        val expected = (10 * 854) + (10 + 10 + 12 + 11 + 11 + 10 + 12 + 12 + 11 + 11) + ((99 * 13) * 3) + ((15 * 99) * 3) + ((14 * 99) * 3)
        assertEquals(expected, NumberLetterCounts().sumLetterCounts(from = 1, numbersUpTo = 1000))
    }

    @Test
    fun `solve, it returns the expected answer`() {
        assertEquals(21124, NumberLetterCounts().solve())
    }
}