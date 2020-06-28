package io.github.mexassi

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class AlmostPalindromeKtTest {

    @Test
    @DisplayName("Halve odd length string should leave the middle char behind")
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
        // those are 1 char away from being palindrome
        assertTrue("MADIM".almostPalindrome())
        assertTrue("1234322".almostPalindrome())
        // this is 2 chars away from being palindrome
        assertFalse("1234333".almostPalindrome())
        // the following are all palindrome
        assertFalse("MADAM".almostPalindrome())
        assertFalse("1234321".almostPalindrome())
        assertFalse("ABBA".almostPalindrome())
    }
}