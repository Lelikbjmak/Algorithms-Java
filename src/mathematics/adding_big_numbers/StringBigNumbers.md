## Description

[KATA](https://www.codewars.com/kata/525f4206b73515bffb000b21/java)

We need to sum big numbers and we require your help.

Write a function that returns the sum of two numbers. The input numbers are strings and the function must return a string.

**For example:**
```
sumStrings("123", "321"); -> "444"
sumStrings("11", "99");   -> "110"
```
Notes: 
* The input numbers are big.
* The input is a string of only digits
* The numbers are positives

---
## Best Practices
```js
public static String sumStrings(String a, String b) {

    StringBuilder r = new StringBuilder();
    int carry = 0;
    int idx = 0;
    
    while(carry != 0 || idx < a.length() || idx < b.length()) {
    
      int x = idx < a.length() ? Character.getNumericValue(a.charAt(a.length() + ~idx)) : 0;
      int y = idx < b.length() ? Character.getNumericValue(b.charAt(b.length() + ~idx)) : 0;
      int m = x + y + carry;
      r.append(m % 10);
      carry = m / 10;
      ++idx;
    }
    
    return r.reverse().toString().replaceAll("^0+","");
}
```

## My solution
```js
    private final static int UNICODE_OF_ZERO_DIGIT_X_2 = 96;
    
    private final static int UNICODE_OF_ZERO_DIGIT = 48;
    
    private final static int DIVISION = 10;
    
    public static String sumStrings(String a, String b) {

        a = a.replaceFirst("^0+(?!$)", ""); // trim all 0 at the beginning of the String
        b = b.replaceFirst("^0+(?!$)", ""); // trim all 0 at the beginning of the String

        char[] longString = null;
        char[] shortString = null;

        if (a.length() > b.length()) {
            longString = a.toCharArray();
            shortString = b.toCharArray();
        } else {
            longString = b.toCharArray();
            shortString = a.toCharArray();
        }

        int addition = 0;

        StringBuilder res = new StringBuilder();

        for (int i = longString.length - 1, j = shortString.length - 1; j > -1; i--, j--) {
            int temporal = longString[i] + shortString[j] - UNICODE_OF_ZERO_DIGIT_X_2 + addition;
            res.append(temporal % DIVISION);
            addition = temporal / DIVISION;
        }

        if (addition > 0)
            for (int i = longString.length - shortString.length - 1; i > -1; i--) {
                int temporal = longString[i] - UNICODE_OF_ZERO_DIGIT + addition;
                res.append(temporal % DIVISION);
                addition = temporal / DIVISION;
            }
        else
            for (int i = longString.length - shortString.length - 1; i > -1; i--) {
                int temporal = longString[i] - UNICODE_OF_ZERO_DIGIT;
                res.append(temporal % DIVISION);
            }

        if (addition > 0)
            res.append(addition);

        return res.reverse().toString();
    }

```