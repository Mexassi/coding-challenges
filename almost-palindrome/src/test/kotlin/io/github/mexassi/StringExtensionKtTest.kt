package io.github.mexassi

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class StringExtensionKtTest {

    @Test
    fun halve_odd() {
        val pair = StringExtension.halve("MADAM")

        assertNotNull(pair)
        assertEquals("MA", pair.first)
        assertEquals("AM", pair.second)
    }

    @Test
    fun halve_even() {
        val pair = StringExtension.halve("ABBA")

        assertNotNull(pair)
        assertEquals("AB", pair.first)
        assertEquals("BA", pair.second)
    }

    @Test
    fun almostPalindrome() {
        assertTrue("MADIM".almostPalindrome())
        assertTrue("1234322".almostPalindrome())
        assertFalse("1234333".almostPalindrome())
        assertFalse("MADAM".almostPalindrome())
        assertFalse("1234321".almostPalindrome())
        assertFalse("ABBA".almostPalindrome())
    }
}