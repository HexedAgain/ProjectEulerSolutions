package utils.primes

import extensions.divides
import kotlin.math.sqrt

class PrimeChecker(private val maxSmallPrime: Int = 1000) {
    val smallPrimes = PrimeSieve(maxPrime = maxSmallPrime.toLong()).sieve()
    fun checkPrime(n: Long): Boolean {
        if (maxSmallPrime < sqrt(n.toDouble()).toInt()) throw IllegalStateException("You passed n = $n, but maxSmallPrime is $maxSmallPrime. Set maxSmallPrime to at least sqrt($n) = ${sqrt(n.toDouble()).toInt()}")
        if (n <= 1) return false
        smallPrimes.filter { it <= sqrt(n.toDouble()) }.forEach {
            if (it divides n) return false
        }
        return true
    }
    fun checkPrime(n: Int): Boolean {
        return checkPrime(n.toLong())
    }
}