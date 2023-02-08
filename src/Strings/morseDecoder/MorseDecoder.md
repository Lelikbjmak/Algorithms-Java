## Description

[KATA (pt. 2)](https://www.codewars.com/kata/54b72c16cd7f5154e9000457/java)

In this kata you have to write a Morse code decoder for wired electrical telegraph.

Electric telegraph is operated on a 2-wire line with a key that, when pressed, connects the wires together, which can be detected on a remote station. The Morse code encodes every character being transmitted as a sequence of "dots" (short presses on the key) and "dashes" (long presses on the key).

When transmitting the Morse code, the international standard specifies that:
* "Dot" – is 1 time unit long.
* "Dash" – is 3 time units long. 
* Pause between dots and dashes in a character – is 1 time unit long. 
* Pause between characters inside a word – is 3 time units long. 
* Pause between words – is 7 time units long.

However, the standard does not specify how long that "time unit" is.
And in fact different operators would transmit at different speed.
An amateur person may need a few seconds to transmit a single character,
a skilled professional can transmit 60 words per minute, and robotic transmitters may go way faster.

For this kata we assume the message receiving is performed automatically
by the hardware that checks the line periodically, and if the line is connected
(the key at the remote station is down), `1` is recorded, and if the line is not connected
(remote key is up), `0` is recorded. After the message is fully received, it gets to you for
decoding as a string containing only symbols `0` and `1`.

For example, the message `HEY JUDE`, that is `···· · −·−−   ·−−− ··− −·· ·` may be received as follows:

`1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011`

As you may see, this transmission is perfectly accurate according to the standard, and the hardware sampled the line exactly two times per "dot".

That said, your task is to implement two functions:

1. Function decodeBits(bits), that should find out the transmission rate of the message, correctly decode the message to dots ., dashes - and spaces (one between characters, three between words) and return those as a string. Note that some extra 0's may naturally occur at the beginning and the end of a message, make sure to ignore them. Also if you have trouble discerning if the particular sequence of 1's is a dot or a dash, assume it's a dot.
2. Function decodeMorse(morseCode), that would take the output of the previous function and return a human-readable string.
 
All the test strings would be valid to the point that they could be reliably decoded as described above, so you may skip checking for errors and exceptions, just do your best in figuring out what the message is!

---

## Best practices *(with MorseCode dependency)*
***First***
```js
public static String decodeBits(String bits) {
    String trimmedBits = bits.replaceAll("^0+|0+$", "");
    int rate = getRate(trimmedBits);

    String morseCode = "";
    for (String word : trimmedBits.split("0{"+ (7 * rate) +"}")) {
        for (String letter : word.split("0{"+ (3 * rate) +"}")) {
            for (String dot : letter.split("0{" + rate + "}")) {
                morseCode += dot.length() > rate ? '-' : '.';
            }
            morseCode += ' ';
        }
        morseCode += "  ";
    }
    return morseCode;
}

private static int getRate(String bits) {
    int rate = Integer.MAX_VALUE;
    Matcher matcher = Pattern.compile("1+|0+").matcher(bits);
    while (matcher.find()) {
        rate = Math.min(rate, matcher.group().length());
    }
    return rate;
}

public static String decodeMorse(String morseCode) {
    String decoded = "";
    for (String word : morseCode.trim().split("   ")) {
        for (String letter : word.split(" ")) {
            decoded += MorseCode.get(letter);
        }
        decoded += ' ';
    }
    return decoded.trim();
}
```

***Second***
```js
public static String decodeBits(String bits) {
    bits = bits.replaceAll("^0*|0*$", "");
    int timeUnit = Pattern.compile("0+|1+")
                          .matcher(bits)
                          .results()
                          .map(MatchResult::group)
                          .mapToInt(String::length)
                          .min()
                          .orElseGet(bits::length);
    return bits.replace("111".repeat(timeUnit), "-")
               .replace("000".repeat(timeUnit), " ")
               .replace("1".repeat(timeUnit), ".")
               .replace("0".repeat(timeUnit), "");
}

public static String decodeMorse(String morseCode) {
    String decoded = "";
    for (String word : morseCode.split(" "))
        if (word.equals("")) decoded += " ";
        else decoded += MorseCode.get(word);
    return decoded;
}
```

---

## My solution *(without decoding to human lang)*
```js
public static String decodeBits(String bits) {

    // . = 11       1{2}
    // - = 111111   1{6}
    // \\s = 000000  0{6} in word
    // \\s = 00000000000000 0{14} between words

    bits = trimZeroValuesFromBitString(bits);

    String pauseBetweenWords = "0{14}";
    String dashPattern = "1{6}";
    String spacePattern = "0{6}";
    String dotPattern = "1{2}";
    String garbagePattern = "0";

    bits = bits.replaceAll(pauseBetweenWords, "   ");
    bits = bits.replaceAll(dashPattern, "-");
    bits = bits.replaceAll(spacePattern, " ");
    bits = bits.replaceAll(dotPattern, ".");
    bits = bits.replaceAll(garbagePattern, "");


    return bits;
}

public static String trimZeroValuesFromBitString(String bits){

    int begin = 0;
    int end = bits.length();
    int i = 0;

    while (bits.charAt(i++)  == '0')
        begin++;

    i = bits.length() - 1;

    while (bits.charAt(i--) == '0')
        end--;

    return bits.substring(begin, end);
}

public static String decodeMorse(String morseCode) {

    String dashPattern = "-";
    String directSpaceBetweenWordsPattern = "\\s{3}";
    String directSpaceInsideWordsPattern = "\\s";
    String dotPattern = "\\.";
    String addBitsAfterDotPattern = "\\.(?!\\s)"; // find all chars ('.'), where next symbol isn't whitespace \\s
    String addBitsAfterDashPattern = "-(?!\\s)";  // find all chars ('-'), where next symbol isn't whitespace \\s

    morseCode = morseCode.replaceAll(addBitsAfterDotPattern, ".00");
    morseCode = morseCode.replaceAll(addBitsAfterDashPattern, "-00");
    morseCode = morseCode.replaceAll(directSpaceBetweenWordsPattern, "00000000000000");
    morseCode = morseCode.replaceAll(directSpaceInsideWordsPattern, "000000");
    morseCode = morseCode.replaceAll(dashPattern, "111111");
    morseCode = morseCode.replaceAll(dotPattern, "11");

    morseCode = trimZeroValuesFromBitString(morseCode);

    return morseCode;
}
```