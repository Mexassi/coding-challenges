package io.github.mexassi

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

internal class ColumnarCipherKtTest {


    @Test
    fun cipher_unencrypted() {
        val encrypted = ColumnarCipher.cipher("I am Massimo", "secret")
        println("-------------------------------------------------")
        println(encrypted)
//        ColumnarCipher.cipher("s002c7xmo7002ha92627xmm79267ai2c700is61792", "secret")
        // s002c7x mo7002h a92627x mm79267 ai2c700 is61792
        // I am Massimo
        // i, a, m, m, a, s,
        // s, i, m, o, 9, 0,
        // 6, 2, 7, 7, 2, 0,
        // 1, c, 9, 0, 6, 2,
        // 7, 7, 2, 0, 2, c,
        // 9, 0, 6, 2, 7, 7,
        // 2, 0, 7, h, x, x,
        // 5, 4, 3, 1, 2, 0,
    }

    @Test
    fun foo() {
        val random = Random()

        val f = random.nextInt(26) + 'a'.toInt()
        println(f.toChar())
    }
}