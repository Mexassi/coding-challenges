package io.github.mexassi.strings

import kotlin.math.floor

/**
 * Check whether the string length is an add or an even number
 * @return true when the length is an even number; false when the length is an odd number
 */
fun String.hasEvenLength() = _hasEvenLength(this)

/**
 * Splits the string in the middle returning a triple with the first half, the second half and the middle char as third.
 * The middle char will be returned as an empty string when the length is an even number
 */
fun String.halve() = _halve(this)

/**
 * Checks whether a string contains alpha-numeric characters only
 * @param string the string to check the chars for
 * @return true when the string only contains alpha-numeric characters, false otherwise
 */
fun String.isAlphaNumeric() = _isAlphaNumeric(this)

private fun _hasEvenLength(string: String): Boolean {
    return string.length % 2 == 0
}

private fun _halve(string: String) : Triple<String, String, String> {
    if (string.hasEvenLength()) {
        val half = string.length / 2
        // leave the third an empty string since the length is even
        return Triple(string.substring(0, half), string.substring(half, string.length), "")
    }
    val half = floor((string.length / 2).toDouble()).toInt()
    return Triple(string.substring(0, half),
        string.substring(half + 1, string.length),
        // set the middle char as third
        string.substring(half, half + 1))
}

private fun _isAlphaNumeric(string: String): Boolean {
    for (char in string) {
        if (!char.isLetterOrDigit()) {
            return false
        }
    }
    return true;
}