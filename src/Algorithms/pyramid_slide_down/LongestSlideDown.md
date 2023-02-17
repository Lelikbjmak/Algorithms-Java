## Description

[Kata](https://www.codewars.com/kata/551f23362ff852e2ab000037/java)

Pyramids are amazing!
Both in architectural and mathematical sense.
If you have a computer, you can mess with pyramids even if you are not in Egypt at the time.
For example, let's consider the following problem.
Imagine that you have a pyramid built of numbers, like this one here:
```js
   /3/
  \7\ 4 
 2 \4\ 6 
8 5 \9\ 3
```
**Here comes the task...**
<br>
Let's say that the 'slide down' is the maximum sum of consecutive numbers from the top to the bottom of the pyramid.
As you can see, the longest 'slide down' is `3 + 7 + 4 + 9 = 23`

Your task is to write a function that takes a pyramid representation as an argument and returns its largest 'slide down'.
For example:
```js
* With the input `[[3], [7, 4], [2, 4, 6], [8, 5, 9, 3]]`
* Your function should return `23`.
```

## My solution
```js
for (int i = pyramid.length - 2; i >= 0; i--) {
        for (int j = 0; j < pyramid[i].length; j++) {
            pyramid[i][j] = pyramid[i][j] + Math.max(pyramid[i+1][j], pyramid[i+1][j+1]);
        }
    }

    return pyramid[0][0];
```
**Explanation:**
Each element of matrix has 2 choice cases of greater element after current (like binary tree).
```
         1
        2 3
       4 5 6
      7 8 9 10
   11 12 13 14 15
```
Element 4 has 2 cases :
<br>
4 -> 7 or 4 -> 8, 8 > 7 -> bigger path through element 4 - path begins from 8, hence 8->4, each element in a row has such opportunity:
<br>
5 -> 8 or 5-> 9, 9 > 8 -> bigger path through 5 - path begins from 9 ...
<br>
Overall for each element we can count the biggest amount we come with, for element 3: 10 -> 6 -> 3 = 19, do the same for each element.

## Best Practices
```js
public static int longestSlideDown(int[][] pyramid) {
    IntStream
        .iterate(pyramid.length - 2, i -> i - 1)
        .limit(pyramid.length - 1)
        .forEach(i -> IntStream
            .rangeClosed(0, i)
            .forEach(j ->
                 pyramid[i][j] += Math.max(pyramid[i+1][j], pyramid[i+1][j+1])));
    return pyramid[0][0];
}
```