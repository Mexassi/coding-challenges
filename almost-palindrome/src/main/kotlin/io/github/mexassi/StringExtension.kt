package kotlin.io.github.mexassi

fun String.isAlmostPalindrome() = _isAlmostPalindrome(this)

private fun _isAlmostPalindrome(string: String): Boolean {
    val pair = StringExtension.halve(string)
    val firstHalf = pair.first
    val reversedSecondHalf = pair.second

    if (firstHalf == reversedSecondHalf) {
        // this is a palindrome
        return false
    }

    for ((index, value) in reversedSecondHalf.withIndex()) {
        val mirror = firstHalf[index]
        if (value == mirror) {
            val remainingFirstHalf = firstHalf.substring(index + 1, firstHalf.length - 1)
            val remainingSeconfHalf = reversedSecondHalf.substring(index + 1, remainingFirstHalf.length - 1)
            return remainingFirstHalf == remainingSeconfHalf
        }
    }
    return false
}

class StringExtension {
    companion object {
        public fun halve(string: String): Pair<String, String> {
            if (string.length % 2 == 0) {
                val half = string.length / 2
                return Pair(string.substring(0, half - 1), string.substring(half, string.length - 1))
            }
            val flooredHalf = Math.floor((string.length / 2).toDouble()).toInt()
            return Pair(string.substring(0, flooredHalf -1), string.substring(flooredHalf + 1, string.length - 1))
        }
    }
}