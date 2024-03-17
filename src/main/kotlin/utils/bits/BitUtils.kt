package utils.bits

import java.util.BitSet

fun nToBits(n: Int) = nToBits(n.toLong())
fun nToBits(n: Long): List<Byte> {
    var N = msb(n)
    val bits: MutableList<Byte> = MutableList(N) { 0 }
    var curr = n
    var i = 0
    N--
    while (curr > 0) {
        bits[N - i++] = if (curr and 1L == 1L) 1 else 0
        curr = curr.shr(1)
    }
    return bits
}

/**
 * Finds most significant bit position
 */
fun msb(n: Long): Int {
    var pos = 0
    var curr = n
    while (curr > 0) { curr = curr.shr(1); pos++ }
    return pos
}
