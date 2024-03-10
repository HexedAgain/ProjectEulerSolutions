package extensions

import kotlin.math.sqrt

fun iSqrt(n: Int): Int {
    return sqrt(n.toDouble()).toInt()
}

fun lSqrt(n: Long): Long {
    return sqrt(n.toDouble()).toLong()
}
