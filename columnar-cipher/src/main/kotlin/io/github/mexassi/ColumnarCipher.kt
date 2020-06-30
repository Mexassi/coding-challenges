package io.github.mexassi

import io.github.mexassi.strings.isAlphaNumeric
import kotlin.math.abs

class ColumnarCipher {
    companion object {
        fun cipher(string: String, key: String): String {

            val sm = StringMatrix(string, key)

            sm.printMatrix()
            println("-----------------")

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
                    line += row[index]
                }
                cipherArray[code] = line
            }

            return cipherArray.joinToString("")
        }

        private fun decrypt(sm: StringMatrix): String {
            // read the matrix line by line
            val matrix = sm.getMatrix()
            val orderedString = matrix.map { it -> it.joinToString("") }
                    .map { it -> it }
                    .joinToString("")
            // split the string where the numbers starts
            val parts = arrayListOf<String>()
            // split the numbers where each char is
            var position = 0
            var candidate = ""
            while (position < orderedString.length - 1) {
                if (orderedString[position].isLetter()) {
                    candidate += orderedString[position]
                    position++
                    continue
                }

                if (orderedString[position].isDigit()) {
                    parts.add(candidate)
                    candidate = ""
                    break
                }
            }

            while (position < orderedString.length) {
                if (orderedString[position].isDigit()) {
                    candidate += orderedString[position]
                    position++
                    continue
                }

                if (orderedString[position].isLetter() && candidate.isEmpty()) {
                    break
                }

                if (orderedString[position].isLetter()) {
                    parts.add(candidate)
                    candidate = ""
                    position++
                }
            }

            val hashCode = sm.codeKey()
            val wordsLength = arrayListOf<Int>()

            for ((index, value) in parts.withIndex()) {
                if (index == 0) {
                    continue
                }
                wordsLength.add(value.toInt() - hashCode)
            }

            candidate = parts.get(0)

            var phrase = ""
            position = 0
            for (wordLength in wordsLength) {
                phrase += candidate.substring(position, position + wordLength) + " "
                position += wordLength
            }

            // get the key hashcode
            // to each number left subtract the hashcode to get the word number
            // substring the first part of the string with those numbers and retrieve the phrase
            return phrase.trim()
        }
    }
}