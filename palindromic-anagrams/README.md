## Palindromic Anagrams
Given a word, create a function which returns whether or not it's possible to create a palindrome by rearranging the letters in the word.

### Examples
```
isPalindromePossible("rearcac") ➞ true
// You can make "racecar"

isPalindromePossible("suhbeusheff") ➞ true
// You can make "sfuehbheufs" (not a real word but still a palindrome)

isPalindromePossible("palindrome") ➞ false
// It's impossible
```
## Notes
- Trivially, words which are already palindromes return true.
- Words are given in all lowercase.