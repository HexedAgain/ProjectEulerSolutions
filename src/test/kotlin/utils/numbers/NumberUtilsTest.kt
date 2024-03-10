package utils.numbers

import org.junit.Assert
import org.junit.Test

class NumberUtilsTest {
    @Test
    fun `factorise, it factorises primes correctly`() {
        Assert.assertEquals(mutableMapOf(2L to 1L), factorise(2))
        Assert.assertEquals(mutableMapOf(13L to 1L), factorise(13))
    }

    @Test
    fun `factorise, it factorises simple non-squarefree primes correctly`() {
        Assert.assertEquals(mutableMapOf(2L to 3L), factorise(8))
        Assert.assertEquals(mutableMapOf(13L to 2L), factorise(169))
    }

    @Test
    fun `factorise, it factorises mixed squarefree primes correctly`() {
        Assert.assertEquals(mutableMapOf(2L to 1L, 3L to 1L), factorise(6))
        Assert.assertEquals(mutableMapOf(13L to 1L, 17L to 1L), factorise(221))
    }

    @Test
    fun `factorise, it factorises mixed non-squarefree primes correctly`() {
        Assert.assertEquals(mutableMapOf(2L to 3L, 3L to 3L), factorise(216))
        Assert.assertEquals(mutableMapOf(13L to 2L, 17L to 3L), factorise(830297))
    }

    @Test
    fun `factorise, it factorises product of two distant primes correctly`() {
        Assert.assertEquals(mutableMapOf(13L to 1L, 9973L to 1L), factorise(129649))
        Assert.assertEquals(mutableMapOf(13L to 3L, 9973L to 2L), factorise(218515221613))
    }
}