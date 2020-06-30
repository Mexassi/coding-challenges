package io.github.mexassi

class ColumnarCipher {
    companion object {
        fun cipher(string: String, key: String): String {
            // check if the string is encrypted

            val cc = StringMatrix(string, key)

            cc.printMatrix()

            return ""
        }
    }
}