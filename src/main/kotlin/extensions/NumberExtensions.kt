package extensions

fun Int.isEven(): Boolean {
    return this % 2 == 0
}
fun Int.isOdd(): Boolean {
    return this % 2 == 1
}
fun Long.isEven(): Boolean {
    return this % 2 == 0L
}
fun Long.isOdd(): Boolean {
    return this % 2 == 1L
}