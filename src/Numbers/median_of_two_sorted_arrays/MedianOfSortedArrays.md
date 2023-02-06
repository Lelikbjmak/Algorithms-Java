## Description

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

**Example**
1.
```js
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
```
2.
```js
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
```

***Constraints***

* nums1.length == m
* nums2.length == n
* 0 <= m <= 1000
* 0 <= n <= 1000
* 1 <= m + n <= 2000
* -106 <= nums1[i], nums2[i] <= 106

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

* [->Merge sort here<-](https://github.com/Lelikbjmak/Algorithms-Java/blob/master/src/sorting_algorithms/mergeSort/mergeSortAlgorithm.java)
