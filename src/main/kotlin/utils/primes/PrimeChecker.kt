package utils.primes

import kotlin.math.sqrt

class PrimeChecker {
    val smallPrimes = PrimeSieve(maxPrime = 1000).sieve()
    fun checkPrime(n: Int): Boolean {
        if (n <= 1) return false
        smallPrimes.filter { it <= sqrt(n.toDouble()) }.forEach {
            if ((n / it) * it == n) return false
        }
        return true
    }
}