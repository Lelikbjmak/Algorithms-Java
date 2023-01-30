## Description

[KATA](https://www.codewars.com/kata/51ba717bb08c1cd60f00002f/train/java)

A format for expressing an ordered list of integers
is to use a comma separated list of either

* individual integers
* or a range of integers denoted by the starting integer separated from the end integer in the range by a dash, '-'. The range includes all integers in the interval including both endpoints. It is not considered a range unless it spans at least 3 numbers. For example "12,13,15-17"

Complete the solution so that it takes a list of integers in increasing order and returns a correctly formatted string in the range format.

***Example***

```js
Solution.rangeExtraction(new int[] {-10, -9, -8, -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20})
# returns "-10--8,-6,-3-1,3-5,7-11,14,15,17-20"
```

---

## Best practices

## My solution

***Only for valid input***
```js
public static String rangeExtraction(int[] arr) {

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < arr.length - 1; ) {

            int tempIndex = i;

            builder.append(arr[i]);
            while (i != arr.length - 1 && arr[i + 1] - arr[i] == 1)
                i++;

            if (i - tempIndex > 1) {  // indicates that we have a 3 serial number in a raw
                builder.append("-");
                builder.append(arr[i]);
            } else
                if(i - tempIndex > 0) // == 1
                    i--;

            i++;
            builder.append(',');
        }

        return builder.deleteCharAt(builder.length() - 1).toString();
    }
```