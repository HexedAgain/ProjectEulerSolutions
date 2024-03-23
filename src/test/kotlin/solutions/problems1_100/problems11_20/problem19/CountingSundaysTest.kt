package solutions.problems1_100.problems11_20.problem19

import org.junit.Assert.*
import org.junit.Test
import solutions.problems1_100.problems11_20.problem19.CountingSundays.Month

class CountingSundaysTest {
    @Test
    fun `numSundays, between Jan 1900 and Dec 1900 it finds 2 Sundays falling on first of the month`() {
        val expected = 2

        assertEquals(expected, CountingSundays().numSundays(monthYearTo = CountingSundays.MonthYearTo(yearTo = 1900, monthTo = Month.DEC)))
    }
    @Test
    fun `numSundays, between Jan 1900 and Dec 1902 it finds 4 Sundays falling on first of the month`() {
        val expected = 5

        assertEquals(expected, CountingSundays().numSundays(monthYearTo = CountingSundays.MonthYearTo(yearTo = 1902, monthTo = Month.DEC)))
    }

    @Test
    fun `isLeapYear, it returns false for 1901`() {
        assertEquals(false, CountingSundays().isLeapYear(year = 1901))
    }
    @Test
    fun `isLeapYear, it returns true for 1904`() {
        assertEquals(true, CountingSundays().isLeapYear(year = 1904))
    }
    @Test
    fun `isLeapYear, it returns false for 1900`() {
        assertEquals(false, CountingSundays().isLeapYear(year = 1900))
    }
    @Test
    fun `isLeapYear, it returns true for 2000`() {
        assertEquals(true, CountingSundays().isLeapYear(year = 2000))
    }
    @Test
    fun `solve, it finds 171 sundays occurring on first of month between Jan 1900 and Dec 2000`() {
        assertEquals(171, CountingSundays().solve())
    }
}