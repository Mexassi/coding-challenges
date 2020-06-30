package io.github.mexassi

import io.github.mexassi.strings.isAlphaNumeric
import kotlin.math.abs
import kotlin.math.ceil

class StringMatrix(private val string: String, private val key: String) {

    private val code: Array<Char>
    private val matrix: Array<Array<Char>>

    init {
        code = codeFor(key)
        matrix = initMatrix()
    }

    fun printMatrix() {
        for (value in matrix) {
            for (inner in value) {
                print("$inner, ")
            }
            println("")
        }

        for (c in code) {
            print("${c.toInt()}, ")
        }
        println()
    }

    private fun initMatrix(): Array<Array<Char>> {
        if (!string.isAlphaNumeric()) {
            // this is an encrypted message
            return decryptedMatrix()
        }
        // this is a decrypted message
        return encryptedMatrix()
    }

    private fun encryptedMatrix(): Array<Array<Char>> {
        return emptyArray()
    }

    private fun decryptedMatrix(): Array<Array<Char>> {
        val s = cleanString(string)
        val cols = key.length
        val size = s.length

        var rows = ceil(((size).toDouble() / (cols).toDouble())).toInt()

        val m: Array<Array<Char>> =  Array(rows) { CharArray(cols).toTypedArray() }


        var index = 0
        var position = 0

        while (rows > 0) {
            if (rows == 1) {
                // TODO handle the last case if the chars left are less than the size
                var remaining = s.substring(position, s.length)

                while (remaining.length < cols) {
                    remaining += "x"
                }
                m[index] = remaining.toCharArray().toTypedArray()
                break;
            }
            m[index] = s.substring(position, position + cols).toCharArray().toTypedArray()
            index++
            position += cols
            rows--
        }

        return m
    }

    private fun cleanString(string: String): String {
        val chars = arrayListOf<Char>()

        for (char in string) {
            if (char.isLetterOrDigit()) {
                chars.add(char)
            }
        }

        return chars.joinToString("").toLowerCase()
    }


    private companion object {
        fun codeFor(key: String): Array<Char> {
            val size = key.length
            val hashCode = abs(key.hashCode())
            val hashCodeChars = hashCode.toString().toCharArray()
            val candidates = arrayListOf<Int>()

            for (char in hashCodeChars) {
                val num: Int = Integer.valueOf(char.toString())
                if (num < size) {
                    if (!candidates.contains(num)) {
                        candidates.add(num)
                    }
                }
            }

            val codes = arrayListOf<Char>()

            for (n in candidates) {
                codes.add(n.toChar())
            }

            var index = 0

            while (codes.size < key.length) {
                if (codes.contains(index.toChar())) {
                    index++
                    continue
                }

                codes.add(index.toChar())
            }

            return codes.toTypedArray().reversedArray()
        }
    }
}