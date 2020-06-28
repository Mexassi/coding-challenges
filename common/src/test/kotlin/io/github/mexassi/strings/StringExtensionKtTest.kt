package io.github.mexassi.strings

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class StringExtensionKtTest {

    @Test
    @DisplayName("Halve odd length string should leave the middle char behind")
    fun halve_odd() {
        val triple = "MADAM".halve()

        assertNotNull(triple)
        assertEquals("MA", triple.first)
        assertEquals("AM", triple.second)
        assertEquals("D", triple.third)
    }

    @Test
    fun halve_even() {
        val triple = "ABBA".halve()

        assertNotNull(triple)
        assertEquals("AB", triple.first)
        assertEquals("BA", triple.second)
        assertEquals("", triple.third)
    }
}