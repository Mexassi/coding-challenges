package io.github.mexassi

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ColumnarCipherKtTest {


    @Test
    fun cipher_unencrypted() {
        ColumnarCipher.cipher("I am Massimo", "secret")

    }
}