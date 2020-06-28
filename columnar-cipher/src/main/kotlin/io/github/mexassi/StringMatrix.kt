package io.github.mexassi

import kotlin.math.abs

class StringMatrix(private val string: String, private val key: String) {

    private val code: Array<Char>
    private val matrix: Array<Array<Char>>

    init {
        code = codeFor(key)
        matrix = initMatrix()
    }

    private fun initMatrix(): Array<Array<Char>> {
//        if (string.matches(alphaNumericRegex)) {
//            // this is an encrypted message
//            return encryptedMatrix()
//        } else {
//            // this is a decrypted message
//            return decryptedMatrix()
//        }
        return emptyArray()
    }

    private fun encryptedMatrix(): Array<Array<Char>> {
        return emptyArray()
    }

    private fun decryptedMatrix(): Array<Array<Char>> {
        return emptyArray()
    }


    private companion object {
        fun codeFor(key: String): Array<Char> {
            val size = key.length // 6
            val hashCode = abs(key.hashCode()) // 906277200
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