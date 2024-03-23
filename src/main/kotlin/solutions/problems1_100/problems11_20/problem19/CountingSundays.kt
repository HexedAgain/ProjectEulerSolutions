package solutions.problems1_100.problems11_20.problem19

import solutions.NoArgSolution

/*
 *
 * You are given the following information, but you may prefer to do some research for yourself.
 *
 *     1 Jan 1900 was a Monday.
 *     Thirty days has September,
 *     April, June and November.
 *     All the rest have thirty-one,
 *     Saving February alone,
 *     Which has twenty-eight, rain or shine.
 *     And on leap years, twenty-nine.
 *     A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 *
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 *
 */
class CountingSundays: NoArgSolution<Int> {
    override val problemNumber = 19
    override val problemName = "Counting Sundays"
    override val problemNotes = """
        One way, albeit slowly, of doing this would be to loop through each of the days, respecting leap year rules
        and count the sundays as we go along
    """.trimIndent()

    override fun solve(): Int {
        return numSundays(monthYearTo = MonthYearTo(yearTo = 2000, monthTo = Month.DEC)) - numSundays(monthYearTo = MonthYearTo(yearTo = 1900, monthTo = Month.DEC))
    }

    enum class Month(val days: Int) {
        JAN(days = 31), FEB(days = 28), MARCH(days = 31), APRIL(days = 30), MAY(days = 31), JUNE(days = 30),
        JULY(days = 31), AUG(days = 31), SEPT(days = 30), OCT(days = 31), NOV(days = 30), DEC(days = 31)
    }
    enum class Day { MON, TUES, WEDS, THUR, FRI, SAT, SUN }

    data class MonthYearTo(
        val yearTo: Int,
        val monthTo: Month,
    )

    fun isLeapYear(year: Int): Boolean {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
    }

    fun numSundays(monthYearTo: MonthYearTo): Int {
        var currDay = Day.MON
        var sundays = 0
        val months = Month.values()
        val days = Day.values()
        fun proc(month: Month, year: Int) {
            val daysInMonth = when(month) {
                Month.FEB -> if (isLeapYear(year)) 29 else 28
                else -> month.days
            }
            currDay = days[(currDay.ordinal + daysInMonth) % 7]
            if (currDay == Day.SUN) sundays++
        }

        (1900 until monthYearTo.yearTo).forEach { year ->
            (Month.JAN.ordinal..Month.DEC.ordinal).forEach {
                proc(months[it], year)
            }
        }
        (monthYearTo.yearTo .. monthYearTo.yearTo).forEach { year ->
            (Month.JAN.ordinal..monthYearTo.monthTo.ordinal).forEach {
                proc(months[it], year)
            }
        }
        return sundays
    }
}