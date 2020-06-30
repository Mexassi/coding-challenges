package io.github.mexassi

import io.github.mexassi.strings.isAlphaNumeric

class ColumnarCipher {
    companion object {
        fun cipher(string: String, key: String): String {

            val sm = StringMatrix(string, key)

            sm.printMatrix()

            if (string.isAlphaNumeric()) {
                return decrypt(sm)
            }

            return encrypt(sm)
        }

        private fun encrypt(sm: StringMatrix): String {
            // read the matrix from top to bottom using the codes as order
            val cipherArray =  Array(sm.getKey().length) { "" }
            val codes = sm.getCodes()
            val matrix = sm.getMatrix()

            for ((index, code) in codes.withIndex()) {
                var line = ""
                for (row in matrix) {
                    line += row[code]
                }
                cipherArray[index] = line
            }

            return cipherArray.joinToString("")
        }

        private fun decrypt(matrix: StringMatrix): String {
            // read the matrix line by line
            // split the string where the numbers starts
            // split the numbers where each char is
            // get the key hashcode
            // to each number left subtract the hashcode to get the word number
            // substring the first part of the string with those numbers and retrieve the phrase
            return ""
        }
    }
}