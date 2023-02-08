## Description

Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
* ```'.'``` Matches any single character.
* ```'*'``` Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

***Example***
```js
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
```

***Constraints:***

* 1 <= s.length <= 20
* 1 <= p.length <= 30
* s contains only lowercase English letters.
* p contains only lowercase English letters, '.', and '*'.
* It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.

## Solution
```js
public boolean isMatch(String text, String pattern) {

    //'.' - 1 any char
    //'*' - any chars

    if (pattern.isEmpty())
        return text.isEmpty();
    // It is guaranteed for each appearance of the character '*', there will be a previous valid character to match. hence -> found first match
    boolean firstMatch = (!text.isEmpty() &&
            (text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.'));


    if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
        return (isMatch(text, pattern.substring(2)) ||
                (firstMatch && isMatch(text.substring(1), pattern)));
    } else
        return firstMatch && isMatch(text.substring(1), pattern.substring(1));
}
```