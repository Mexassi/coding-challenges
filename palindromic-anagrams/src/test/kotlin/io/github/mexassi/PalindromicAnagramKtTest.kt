package io.github.mexassi

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PalindromicAnagramKtTest {

    @Test
    fun palindromicAnagram() {
        assertTrue("RACECrA".isPalindromicAnagram())
        assertFalse("cAR".isPalindromicAnagram())
    }
}