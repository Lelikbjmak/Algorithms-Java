## Description
[Taska](https://leetcode.com/problems/3sum/description/)

Given an integer array nums, return all the triplets `[nums[i], nums[j], nums[k]` such that `i != j`, `i != k`,
and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

Notice that the solution set must not contain duplicate triplets.

### Examples

*First*
```js
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
```

*Second*
```js
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
```

*Third*
```js
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
```

---

## My solution
```js
public List<List<Integer>> threeSum(int[] numbers) {

    if(numbers.length == 0)
        return new ArrayList<>();

    Set<List<Integer>> distinctTriplets = new HashSet<>();

    Arrays.sort(numbers);
    // -1 -2 3 4 5 6 ... -> for each two elements in a raw (like -1 & -2 etc) find value (start from tail of array) equal to current sum -3 = 3 -> triplet = [-1,-2,3]

    for (int i = 0; i < numbers.length - 2; i++) {

        int j = i + 1; // elem after current
        int k = numbers.length - 1; // last elem

        while(j < k){
            int sum = numbers[i] + numbers[j] + numbers[k];

            if(sum==0)
                distinctTriplets.add(List.of(numbers[i], numbers[j++], numbers[k--]));
            else if (sum >0)
                 k--;
                else
                    j++;
        }

    }

    return new ArrayList<>(distinctTriplets);
}
```

