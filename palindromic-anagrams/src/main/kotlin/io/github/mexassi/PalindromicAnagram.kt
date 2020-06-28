package io.github.mexassi

import io.github.mexassi.strings.hasEvenLength

/**
 * Check whether the string is an anagram of a palindrome
 * @return true when the string is a palindrome anagram or false when the string is not a palindrome anagram
 */
fun String.isPalindromicAnagram() = palindromicAnagram(this)

private fun palindromicAnagram(string: String): Boolean {
    val s = string.toLowerCase()

    val list = arrayListOf<Char>()

    for (char in s) {

        // add the char when the list is empty and continue
        if (list.isEmpty()) {
            list.add(char)
            continue
        }

        if (list.contains(char)) {
            // remove the char when contained in the list
            list.remove(char)
        } else {
            // add the char when not in the list
            list.add(char)
        }
    }

    if (s.hasEvenLength()) {
        // the list is empty when the string length is an even number
        return list.isEmpty()
    }

    // the list size is 1 when the string length is an odd number
    return list.size == 1
}