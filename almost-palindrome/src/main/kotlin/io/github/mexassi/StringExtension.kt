package kotlin.io.github.mexassi

/**
 * Check whether the string is almost a palindrome, meaning the string is 1 char away from being a palindrome
 * @return true if the string is almost a palindrome or false when not
 */
fun String.isAlmostPalindrome() = _isAlmostPalindrome(this)

private fun _isAlmostPalindrome(string: String): Boolean {
    // halve the string
    val pair = StringExtension.halve(string)
    val firstHalf = pair.first
    val reversedSecondHalf = pair.second

    if (firstHalf == reversedSecondHalf) {
        // this is a palindrome
        return false
    }

    for ((index, value) in reversedSecondHalf.withIndex()) {
        val mirror = firstHalf[index]
        if (value != mirror) {
            // the first difference has been found
            val remainingFirstHalf = firstHalf.substring(index + 1, firstHalf.length - 1)
            val remainingSeconfHalf = reversedSecondHalf.substring(index + 1, remainingFirstHalf.length - 1)
            // returns whether there are more differences or this is just one char away from being a palindrome
            return remainingFirstHalf == remainingSeconfHalf
        }
    }
    return false
}

class StringExtension {
    companion object {
        /**
         * Function that halves a string into a pair containing the first and second half of the string
         * When the string length is an odd number the middle char is left behind
         *
         * @param string the string to halve
         * @return a pair containing the first and second half of the string
         */
        fun halve(string: String): Pair<String, String> {
            if (string.length % 2 == 0) {
                val half = string.length / 2
                return Pair(string.substring(0, half - 1), string.substring(half, string.length - 1))
            }
            val flooredHalf = Math.floor((string.length / 2).toDouble()).toInt()
            // leave the middle character behind
            return Pair(string.substring(0, flooredHalf -1), string.substring(flooredHalf + 1, string.length - 1))
        }
    }
}