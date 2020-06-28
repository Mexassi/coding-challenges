package io.github.mexassi

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class AlmostPalindromeKtTest {

    @Test
    fun almostPalindrome() {
        // those are 1 char away from being palindrome
        assertTrue("MADIm".almostPalindrome())
        assertTrue("1234322".almostPalindrome())
        // this is 2 chars away from being palindrome
        assertFalse("1234333".almostPalindrome())
        // the following are all palindrome
        assertFalse("MADAM".almostPalindrome())
        assertFalse("1234321".almostPalindrome())
        assertFalse("ABBA".almostPalindrome())
    }
}