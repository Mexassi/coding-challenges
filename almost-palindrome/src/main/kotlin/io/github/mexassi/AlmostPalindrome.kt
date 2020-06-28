package io.github.mexassi

import io.github.mexassi.strings.halve

/**
 * Check whether the string is almost a palindrome, meaning the string is 1 char away from being a palindrome.
 * The function splits the string into 2 equal halves (the middle char is left behind for odd length strings).
 * The second half of the string is reversed and then each char is checked against it's mirroring char from the first
 * half. Once the first difference is found, the function returns whether there are more differences in the remaining
 * halves.
 * @return true if the string is almost a palindrome or false when not
 */
fun String.almostPalindrome() = isAlmostPalindrome(this)

private fun isAlmostPalindrome(string: String): Boolean {
    // halve the string
    val triple = string.halve()
    val firstHalf = triple.first
    val reversedSecondHalf = triple.second.reversed()

    if (firstHalf == reversedSecondHalf) {
        // this is a palindrome
        return false
    }

    for ((index, value) in reversedSecondHalf.withIndex()) {
        val mirror = firstHalf[index]
        if (value != mirror) {
            // the first difference has been found
            if (index == reversedSecondHalf.length - 1) {
                // if this is the last char of the string, there are no more differences
                return true;
            }
            // returns whether there are more differences or this is just one char away from being a palindrome
            val remainingFirstHalf = firstHalf.substring(index + 1, firstHalf.length)
            val remainingSecondHalf = reversedSecondHalf.substring(index + 1, reversedSecondHalf.length)
            return remainingFirstHalf == remainingSecondHalf
        }
    }
    return false
}