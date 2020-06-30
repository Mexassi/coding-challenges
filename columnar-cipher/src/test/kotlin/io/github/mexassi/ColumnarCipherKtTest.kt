package io.github.mexassi

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ColumnarCipherKtTest {


    @Test
    fun cipher_unencrypted() {
        val text = "I see a rainbow and I want to paint it black"
        val encrypted = ColumnarCipher.cipher(text, "as09d70a9s")
        assertNotNull(encrypted)
        assertNotEquals(text, encrypted)

        val decrypted = ColumnarCipher.cipher(encrypted, "as09d70a9s")

        assertEquals(text.toLowerCase(), decrypted)

    }
}