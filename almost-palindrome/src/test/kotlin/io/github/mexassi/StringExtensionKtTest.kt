package io.github.mexassi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
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
}