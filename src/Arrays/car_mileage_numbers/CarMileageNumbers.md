## Description

[KATA](https://www.codewars.com/kata/52c4dd683bfd3b434c000292/train/java)

`|`"7777...8?!??!", exclaimed Bob, "I missed it again! Argh!" Every time there's an interesting number coming up,
he notices and then promptly forgets. Who doesn't like catching those one-off interesting mileage numbers?
`|`

Let's make it so Bob never misses another interesting number.
We've hacked into his car's computer, and we have a box hooked up that reads mileage numbers.
We've got a box glued to his dash that lights up yellow or green depending on whether it receives a `1` or a `2` (respectively).

It's up to you, intrepid warrior, to glue the parts together.
Write the function that parses the mileage number input,
and returns a `2` if the number is "interesting" (see below),
a `1` if an interesting number occurs within the next two miles, or a `0` if the number is not interesting.

**Note:** In Haskell, we use No, Almost and Yes instead of `0`, `1` and `2`.

---

### "Interesting" Numbers
Interesting numbers are 3-or-more digit numbers that meet one or more of the following criteria:
* Any digit followed by all zeros: `100`, `90000`
* Every digit is the same number: `1111`
* The digits are sequential, incementing†: `1234`
* The digits are sequential, decrementing‡: `4321`
* The digits are a palindrome: `1221` or `73837`
* The digits match one of the values in the `awesomePhrases` array

<div>
† For incrementing sequences, `0` should come after `9`, and not before `1`, as in `7890`.
<br>
‡ For decrementing sequences, `0` should come after `1`, and not before `9`, as in `3210`.
</div>

So, you should expect these inputs and outputs:
```js
// "boring" numbers
CarMileage.isInteresting(3, new int[]{1337, 256});    // 0
CarMileage.isInteresting(3236, new int[]{1337, 256}); // 0

// progress as we near an "interesting" number
CarMileage.isInteresting(11207, new int[]{}); // 0
CarMileage.isInteresting(11208, new int[]{}); // 0
CarMileage.isInteresting(11209, new int[]{}); // 1
CarMileage.isInteresting(11210, new int[]{}); // 1
CarMileage.isInteresting(11211, new int[]{}); // 2

// nearing a provided "awesome phrase"
CarMileage.isInteresting(1335, new int[]{1337, 256}); // 1
CarMileage.isInteresting(1336, new int[]{1337, 256}); // 1
CarMileage.isInteresting(1337, new int[]{1337, 256}); // 2
```

---

### Error Checking
* A number is only interesting if it is greater than `99`!
* Input will always be an integer greater than `0`, and less than `1,000,000,000`.
* The `awesomePhrases` array will always be provided, and will always be an array, but may be empty.
* (Not everyone thinks numbers spell funny words...)
* You should only ever output `0`, `1`, or `2`.

---

## My Solution
```js
private static final String INCREMENTING_STRING = "1234567890";
private static final String DECREMENTING_STRING = "9876543210";

public static int isInteresting(int number, int[] awesomePhrases) {

    if (number < 98)
        return 0;
    else if (number < 100) { // indicates equals 98/99
        return 1;
    } else {  // numeric is grater or equals 100

        // flawless case - number is interesting
        if (isAwesome(number, awesomePhrases))
            return 2;
        else if (isFollowByAllZeros(number))
            return 2;
        else if(isTheSameNumbers(number))
            return 2;
        else if (isSequentialIncrementing(number))
            return 2;
        else if(isSequentialDecrementing(number))
            return 2;
        else if(isPalindrome(number))
            return 2;

        // number is good/ but not interesting (difference = 1/2)

        if (isAwesome(number + 1, awesomePhrases) || isAwesome(number + 2, awesomePhrases))
            return 1;
        else if (isFollowByAllZeros(number + 1) || isFollowByAllZeros(number + 2))
            return 1;
        else if(isTheSameNumbers(number + 1) || isTheSameNumbers(number + 2))
            return 1;
        else if (isSequentialIncrementing(number + 1) || isSequentialIncrementing(number + 2))
            return 1;
        else if(isSequentialDecrementing(number + 1) || isSequentialDecrementing(number + 2))
            return 1;
        else if(isPalindrome(number + 1) || isPalindrome(number + 2))
            return 1;
    }

    return 0;
}

private static boolean isPalindrome(int number) {
    String stringNumber = Integer.toString(number);
    return new StringBuilder(stringNumber).reverse().toString().equals(stringNumber);
}

private static boolean isSequentialDecrementing(int number) {
    String stringNumber = Integer.toString(number);
    return DECREMENTING_STRING.contains(stringNumber);
}

private static boolean isSequentialIncrementing(int number) {
    String stringNumber = Integer.toString(number);
    return INCREMENTING_STRING.contains(stringNumber);
}

private static boolean isTheSameNumbers(int number) {

    int digit = number % 10;

    while (number != 0) {
        int last_digit = number % 10;
        number = number / 10;
        if (last_digit != digit) {
            return false;
        }
    }
    return true;
}

private static boolean isFollowByAllZeros(int number) {
    String stringNumber = Integer.toString(number);
    return ((int) stringNumber.charAt(0) - 48 > 0)  // first digit is not 0
            &&
            stringNumber.substring(1)
                    .equals("0".repeat(stringNumber.length() - 1)); // all remain digits are 0
}

private static boolean isAwesome(int number, int[] awesomePhrases) {

    for (Integer i:
         awesomePhrases) {
        if(i.equals(number))
            return true;
    }

    return false;
}
```

## Best Practices

* *First*

```js
public static boolean isReallyInteresting(int number, final int[] awesomePhrases) {
    return Stream.<Predicate<String>>of(
        s -> s.matches("\\d0+"),
        s -> new StringBuilder(s).reverse().toString().equals(s),
        s -> "1234567890".contains(s),
        s -> "9876543210".contains(s),
        s -> Arrays.stream(awesomePhrases).anyMatch(n -> parseInt(s) == n)
    ).anyMatch( p -> number > 99 && p.test(Integer.toString(number)));
}

public static int isInteresting(int number, int[] awesomePhrases) {
    return isReallyInteresting(number, awesomePhrases) ? 2 : 
       isReallyInteresting(number + 1, awesomePhrases) ? 1 : 
       isReallyInteresting(number + 2, awesomePhrases) ? 1 : 0;
}
```

* *Second*
```js
public static int isInteresting(int number, int[] awesomePhrases) {
 
    if (_isInteresting(number, awesomePhrases)) {
        return 2;
    } else if (_isInteresting(number + 1, awesomePhrases) || _isInteresting(number + 2, awesomePhrases)) {
        return 1;
    } else {
        return 0;
    }
}

private static boolean _isInteresting(int number, int[] awesomePhrases) {
    if (number < 100) return false;
    String  numStr = String.valueOf(number);
    return  numStr.chars().skip(1).filter(i -> i != '0').count() == 0 ||
            numStr.chars().distinct().count() == 1 ||
            "1234567890".contains(numStr) ||
            "9876543210".contains(numStr) ||
            numStr.equals(new StringBuilder(numStr).reverse().toString()) ||
            IntStream.of(awesomePhrases).anyMatch(i -> i == number);
}
```