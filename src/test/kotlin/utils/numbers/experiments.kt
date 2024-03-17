package utils.numbers

import org.junit.Test
import utils.bits.msb
import utils.bits.nToBits
import utils.primes.PrimeSieve
import kotlin.test.assertEquals

class Experiments {
    @Test
    fun `products of consecutive primes, and whether they can be triangular numbers`() {
        val primes = PrimeSieve(maxPrime = 10000).sieve()
        val primeProducts = (1..13).map {
            val product = (1L..it).reduce { acc, i -> primes[i.toInt() - 2] * acc }
            Triple(factorise(product, primes), product, realQuadraticRoots(1.toDouble(), 1.toDouble(), -2 * product.toDouble()))
        }.drop(1)
        primeProducts.forEach {
            println("factors: ${it.first}\nproduct: ${it.second}\ntriangular n: ${it.third.first}")
        }
    }
    @Test
    fun `products of primes, and whether they can be triangular numbers`() {
        val primes = PrimeSieve(maxPrime = 10000).sieve()
        (0..13).forEach { idx1 ->
            val fixedPrime = primes[idx1].toLong()
            println("fixed prime: $fixedPrime")
            val primeProducts =
                (1..13).map { p1 ->
                    (p1..13).map { p2 ->
//                        val product = (p1.toLong()..p2.toLong()).reduce { acc, i -> primes[i.toInt() - 2] * acc } * fixedPrime
                        val product = (p1.toLong()..p2.toLong()).map { primes[it.toInt() - 1] }.reduce {acc, n -> n * acc} * fixedPrime
//                        val product = (p1.toLong()..p2.toLong()).reduce {acc, n -> primes[n.toInt() - 2] * acc} * fixedPrime
                        val factors = factorise(product, primes)
                        Triple(factors, product, realQuadraticRoots(1.toDouble(), 1.toDouble(), -2 * product.toDouble()))
                    }
                }.flatten()
            primeProducts.forEach {
                println("    factors: ${it.first}\n    product: ${it.second}\n    triangular n: ${it.third.first}")
            }
        }


        // want a function that from sequence {1,2,3,4,...} produces series:
        // 1: 1 -> [(1)]
        // 2: 11, 10, 01 -> [(1,1), (2, 0), (0,2)]
        // 3: 111, 110, 101, 100, 011, 010, 001 -> [(1,1,1), (2,1,0), (1,2,0), (2,0,1), (1,0,2), (3,0,0), (0,2,1), (0,1,2), (0,3,0), (0,0,3)]
        // 4: 1111, 1110, 1101, 1100, 1011, 1010, 1001, 1000, 0111, 0110, 0101, 0100, 0011, 0010, 0001 ->
        //    [(1,1,1,1),
        //     (2,1,1,0), (1,2,1,0), (1,1,2,0),
        //     (2,1,0,1), (1,2,0,1), (1,1,0,2),
        //     (3,1,0,0), (2,2,0,0), (1,3,0,0),
        //     (2,0,1,1), (1,0,2,1), (1,0,1,2),
        //     (3,0,1,0), (2,0,2,0), (1,0,3,0),
        //     (3,0,0,1), (2,0,0,2), (1,0,0,3),
        //     (4,0,0,0),
        //     (0,2,1,1), (0,1,2,1), (0,1,1,2),
        //     (0,3,1,0), (0,2,2,0), (0,1,3,0),
        //     (0,3,0,1), (0,2,0,2), (0,1,0,3),
        //     (0,4,0,0),
        //     (0,0,3,1), (0,0,2,2), (0,0,1,3),
        //     (0,0,4,0),
        //     (0,0,0,4)]
        // 1: [(1)] -> [1]
        // 2: [(3 + 1), (2*3 + 0), (0, 2)] -> [4, 6, 2]
        // 3: [(4*4+4+1), (2*4*4+4+0), (4*4+2*4+0), (2*4*4+0+1), (4*4+0+2), (3*4*4+0+0), (0+2*4+1), (0+4+2), (0+3*4+0), (0+0+3)] -> [21, 36, 24, 33, 18, 48, 9, 6, 12, 3]
    }

    @Test
    fun `splitN, given n is 1 it returns ((1))`() {
        val expected = listOf(listOf(1))
        assertEquals(expected, splitN(1))
    }

    @Test
    fun `splitN, given n is 2 it returns ((1,1),(2,0),(0,2))`() {
        val expected = listOf(listOf(1,1), listOf(2,0), listOf(0,2))
        val bits = nToBits(7)
        val msb = msb(11)
        splitN(70)
        assertEquals(expected, splitN(2))
    }

    fun splitN(n: Int): List<List<Int>> {
        (1..n).forEach {
            val parts = nToBits(it)
            val msb = parts.size
            var allocation = it
        }
        return listOf()
    }
}