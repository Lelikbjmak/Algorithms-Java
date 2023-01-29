## Description

Given the string representations of two integers, return the string representation of the sum of those integers.

**For example:**
```
sumStrings('1','2') // => '3'
```
A string representation of an integer will contain no characters besides the ten numerals "0" to "9".

I have removed the use of <b>BigInteger</b> and <b>BigDecimal</b> in java

Python: your solution need to work with huge numbers (about a milion digits), converting to int will not work.

---
## Best Practices

***First:***
```js
public static String sumStrings(String a, String b) {
    final var len = Math.max(a.length(), b.length());
    final var x = leftPad(a, len + 1, '0');
    final var y = leftPad(b, len + 1, '0');

    int cur;
    int rem = 0;
    final var result = new StringBuilder(len + 1);
    for (int i = len; i >= 0; i--) {
        cur = parseInt("" + x.charAt(i)) + parseInt("" + y.charAt(i)) + rem;
        result.insert(0, cur % 10);
        rem = cur / 10;
    }
    return stripStart(result.toString(), "0");
}
```

***Second:***
```js
public static String sumStrings(String aa, String bb) {
    char[] a = aa.replaceFirst("^0+(?!$)", "").toCharArray(), b = bb.replaceFirst("^0+(?!$)", "").toCharArray();
    int carry = 0; StringBuilder sb = new StringBuilder();
    int minL = Math.min(a.length, b.length), maxL = Math.max(a.length, b.length);
    for(int i = maxL - 1; i >= 0; i--){
      int ca = (i + a.length - maxL >= 0 ? a[i + a.length - maxL] : '0') - '0';
      int cb = (i + b.length - maxL >= 0 ? b[i + b.length - maxL] : '0') - '0';
      int s = ca + cb + carry;
      carry = s / 10;
      s %= 10;
      sb.append(s);
    }
    return sb.append(carry != 0 ? carry : "").reverse().toString();
  }
```

---

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