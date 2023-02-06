## Description

Given a string ***s***, find the length of the longest
substring without repeating characters.

**Example:**
1. 
```js
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
```
2.
```js
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```
3.
```js
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
```

***Constraints***
* 0 <= s.length <= 5 * 104
* s consists of English letters, digits, symbols and spaces. 

---

## Solution
```js
  public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        int max = 0;

        while(j < s.length()){

            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            if(map.size() == j - i + 1){
                max = Math.max(max, j - i + 1);
                j++;
            }
            else if(map.size() < j - i + 1){
                while(map.size() < j - i + 1){

                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);

                    if(map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                    i++;
                }

                j++;
            }
        }

        return max;
    }

```